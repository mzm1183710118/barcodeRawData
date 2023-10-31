package org.example;

public class Main {
    public static void main(String[] args) {
        SelfScanner s = new SelfScanner("./src/main/java/data/barcode.png");
        byte[] rawData = s.detectBitMatrixFrom();
        StringBuilder output = new StringBuilder();
        for (byte rawDatum : rawData) {
            output.append(byteToBit(rawDatum));
        }
        System.out.println(output);
    }

    public static String byteToBit(byte b) {
        return "" + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1) + (byte) ((b >> 5) & 0x1)
                + (byte) ((b >> 4) & 0x1) + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);
    }
}