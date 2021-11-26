package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.calculator.IPAddress;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressPartsTest {

    private final IPAddress.AddressParts addressMin = IPAddress.AddressParts.of("0",  "0",   "0",   "0");
    private final IPAddress.AddressParts addressMax = IPAddress.AddressParts.of("255","255", "255", "255");
    private final IPAddress.AddressParts address1 =   IPAddress.AddressParts.of("65", "65",  "0",   "0");
    private final IPAddress.AddressParts address2 =   IPAddress.AddressParts.of("65", "65",  "000", "000");

    private final IPAddress.AddressParts binaryMin = IPAddress.AddressParts.of("00000000", "00000000", "00000000", "00000000" );
    private final IPAddress.AddressParts binaryMax = IPAddress.AddressParts.of("11111111", "11111111", "11111111", "11111111" );
    private final IPAddress.AddressParts binary1 =   IPAddress.AddressParts.of("01000001", "01000001", "00000000", "00000000" );
    private final IPAddress.AddressParts binary2 =   IPAddress.AddressParts.of("01000001", "01000001", "00000000", "00000000" );

    @Test
    public void joinDotTest() {
        assertEquals("0.0.0.0", addressMin.joinDot());
        assertEquals("255.255.255.255", addressMax.joinDot());
        assertEquals("65.65.0.0", address1.joinDot());
        assertEquals("65.65.000.000", address2.joinDot());
    }


    @Test
    public void joinBinaryTest() {
        assertEquals("00000000000000000000000000000000", binaryMin.join());
        assertEquals("11111111111111111111111111111111", binaryMax.join());
        assertEquals("01000001010000010000000000000000", binary1.join());
        assertEquals("01000001010000010000000000000000", binary2.join());
    }

    @Test
    public void joinBinaryDotTest() {
        assertEquals("00000000.00000000.00000000.00000000", binaryMin.joinDot());
        assertEquals("11111111.11111111.11111111.11111111", binaryMax.joinDot());
        assertEquals("01000001.01000001.00000000.00000000", binary1.joinDot());
        assertEquals("01000001.01000001.00000000.00000000", binary2.joinDot());
    }

}
