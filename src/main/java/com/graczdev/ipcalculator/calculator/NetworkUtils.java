package com.graczdev.ipcalculator.calculator;

import java.util.function.Function;

public class NetworkUtils {

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

    public static IPAddress makeAddress(IPAddress address, IPMask mask, AddressType type) {
        String joinedBinary = address.binary().join();
        String removedBinary = joinedBinary.substring(0, mask.getCidr());
        String filledBinary = removedBinary + type.getFill().toString().repeat(32 - mask.getCidr());
        String addressText = IPAddress.AddressParts.of(convert(filledBinary.split(SPLIT_FOR_8_CHAR_PARTS), toDecimalFunction)).joinDot();

        return new IPAddress(addressText);
    }

    public static IPAddress cidrToIPAddress(int cidr) {
        int mask = (0xffffffff >> (32 - cidr)) << (32 - cidr);
        String address =
                (0xff000000 & mask >> 24) + "." +
                (0x00ff0000 & mask >> 16) + "." +
                (0x0000ff00 & mask >> 8)  + "." +
                (0x000000ff & mask);

        return new IPAddress(address);
    }

}
