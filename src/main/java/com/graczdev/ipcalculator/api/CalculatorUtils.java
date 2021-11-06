package com.graczdev.ipcalculator.api;

class CalculatorUtils {

    private static final CalculatorRunnable toBinaryRunnable =
            octet -> String.format("%8s", Integer.toBinaryString(Integer.parseInt(octet)))
                    .replace(" ", "0");
    private static final CalculatorRunnable toDecimalRunnable =
            octet -> String.valueOf(Integer.parseInt(octet, 2));

    public static String[] toBinary(String[] decimal) {
        return convert(decimal, toBinaryRunnable);
    }

    public static String toBinary(String decimal) {
        return String.join("." , convert(decimal.split("\\."), toBinaryRunnable));
    }

    public static String[] toDecimal(String[] binary) {
        return convert(binary, toDecimalRunnable);
    }

    public static String toDecimal(String binary) {
        return String.join(".", convert(binary.split("\\."), toDecimalRunnable));
    }

    private static String[] convert(String[] octetsArr, CalculatorRunnable runnable) {
        String[] result = new String[octetsArr.length];

        for (int i = 0; i < octetsArr.length; i++) {
            result[i] = runnable.run(octetsArr[i]);
        }

        return result;
    }

    public static String makeAddress(String[] addressInBinary, String s, int subnetMaskNumber) {
        final String SPLIT_FOR_8_CHAR_PARTS = "(?<=\\G.{8})";

        String[] formattedArr = (String.join("", addressInBinary)
                .substring(0, subnetMaskNumber)
                + s.repeat(32 - subnetMaskNumber))
                .split(SPLIT_FOR_8_CHAR_PARTS);

        return String.join(".", formattedArr);
    }
}
