package com.example.Enums;

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
}