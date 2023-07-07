package com.example.Enums;

import com.example.Constants.Constants;

public enum SeatNumber {

    A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;


    public static String[] generateSeatNumbers(int numRows, int seatsPerRow) {
        String[] seatNumbers = new String[numRows * seatsPerRow];
        int index = 0;

        for (int row = 0; row < numRows; row++) {
            for (int seat = 1; seat <= seatsPerRow; seat++) {
                seatNumbers[index++] = String.valueOf(SeatNumber.values()[row])+seat;
            }
        }

        return seatNumbers;
    }
    public static int getIndexFromSeatNumber(String seatNumber) {
        char letter = seatNumber.charAt(0);
        int number = Integer.parseInt(seatNumber.substring(1));
        int row = letter - 'A';
        return (row * Constants.SEATS_PER_ROW) + (number - 1);
    }
}