package com.graczdev.ipcalculator.api;

import java.util.function.Function;

class CalculatorUtils {

    private static final String SPLIT_FOR_8_CHAR_PARTS = "(?<=\\G.{8})";

    private static final Function<String, String> toBinaryFunction =
            octet -> String.format("%8s", Integer.toBinaryString(Integer.parseInt(octet)))
                    .replace(" ", "0");

    private static final Function<String, String> toDecimalFunction =
            octet -> String.valueOf(Integer.parseInt(octet, 2));

    public static String[] toBinary(String[] decimal) {
        return convert(decimal, toBinaryFunction);
    }

    public static String toBinary(String decimal) {
        return String.join("." , convert(decimal.split("\\."), toBinaryFunction));
    }

    public static String[] toDecimal(String[] binary) {
        return convert(binary, toDecimalFunction);
    }

    public static String toDecimal(String binary) {
        return String.join(".", convert(binary.split("\\."), toDecimalFunction));
    }

    private static String[] convert(String[] octetsArr, Function<String, String> runnable) {
        String[] result = new String[octetsArr.length];

        for (int i = 0; i < octetsArr.length; i++) {
            result[i] = runnable.apply(octetsArr[i]);
        }

        return result;
    }

    public static String makeAddress(String[] addressInBinary, String s, int subnetMaskNumber) {
        String[] formattedArr = (String.join("", addressInBinary)
                .substring(0, subnetMaskNumber)
                + s.repeat(32 - subnetMaskNumber))
                .split(SPLIT_FOR_8_CHAR_PARTS);

        return String.join(".", formattedArr);
    }
}
