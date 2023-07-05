package com.example;

import com.example.Enums.SeatNumber;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Homework3Application {
	@Bean
	public ModelMapper modelMapper(){return new ModelMapper();}
	public static void main(String[] args) {
		SpringApplication.run(Homework3Application.class, args);

	}

}

