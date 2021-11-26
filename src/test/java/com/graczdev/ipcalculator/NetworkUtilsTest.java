package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.calculator.NetworkUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkUtilsTest {

    @Test
    public void toDecimalTest() {
        assertEquals("0.0.0.0",         NetworkUtils.toDecimal("00000000.00000000.00000000.00000000"));
        assertEquals("65.65.0.0",       NetworkUtils.toDecimal("01000001.01000001.00000000.00000000"));
        assertEquals("65.65.65.65",     NetworkUtils.toDecimal("01000001.01000001.01000001.01000001"));
        assertEquals("255.255.255.255", NetworkUtils.toDecimal("11111111.11111111.11111111.11111111"));

    }

    @Test
    public void toBinaryTest() {
        assertEquals("00000000.00000000.00000000.00000000", NetworkUtils.toBinary("0.0.0.0"));
        assertEquals("01000001.01000001.00000000.00000000", NetworkUtils.toBinary("65.65.0.0"));
        assertEquals("01000001.01000001.00000000.00000000", NetworkUtils.toBinary("65.65.000.000"));
        assertEquals("01000001.01000001.01000001.01000001", NetworkUtils.toBinary("65.65.65.65"));
        assertEquals("11111111.11111111.11111111.11111111", NetworkUtils.toBinary("255.255.255.255"));
    }

}
