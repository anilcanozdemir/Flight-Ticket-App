package com.code16.AOP.CrossCuttingConcerns.Logging.Aspect;


import com.code16.AOP.CrossCuttingConcerns.Logging.LogParameters;
import com.code16.AOP.CrossCuttingConcerns.Logging.LogRepository;
import com.code16.AOP.CrossCuttingConcerns.Logging.LogStatus;
import com.code16.Core.Result.Result;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerToDbAspect {
    private final LogRepository logRepository;

    @Pointcut("@annotation(com.code16.AOP.Annotations.Logging.LoggerToDbForResult)")
    public void callToMethod() {
    }

    @AfterReturning(value = "callToMethod()", returning = "result")
    public void logToDb(JoinPoint point, Result result) throws IllegalAccessException {
        String methodName = point.getSignature().getName();
        Object[] args = point.getArgs();
        String params = "";
        if (args.length > 0) {
            StringBuilder paramsBuilder = new StringBuilder();
            for (Object arg : args) {
                if (arg instanceof Number || arg instanceof String) {

                    paramsBuilder.append(arg.getClass().getSimpleName())
                            .append(":{").append(arg).append("},");

                } else {
                    paramsBuilder.append(arg.getClass().getSimpleName())
                            .append(":{");

                    Field[] fields = arg.getClass().getDeclaredFields();

                    for (Field field : fields) {
                        field.setAccessible(true);
                        paramsBuilder.append(field.getName())
                                .append(":")
                                .append(field.get(arg).toString())
                                .append(", ");
                    }

                    paramsBuilder.append("},");
                }
            }
            params = paramsBuilder.toString();
        }
        LogParameters logParameters = new LogParameters();
        logParameters.setMethodName(methodName);
        logParameters.setParameters(params);
        logParameters.setLogDate(new Date());
        if (result.isSuccess()) logParameters.setLogStatus(LogStatus.INFO);
        else logParameters.setLogStatus(LogStatus.ERROR);
        logParameters.setReturnValue(result.getMessage());
        this.logRepository.save(logParameters);
    }
}
