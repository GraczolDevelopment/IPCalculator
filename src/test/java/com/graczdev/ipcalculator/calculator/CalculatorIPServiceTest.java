package com.graczdev.ipcalculator.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorIPServiceTest {

    @Test
    public void TestOfSubnetCalculatorApi() {
        CalculatorIPService calculatorIPService = new CalculatorIPService();
        AnaliseIPResult result = calculatorIPService.analiseIP(new IPAddress("185.146.54.21"), IPMask.MASK_20);

        assertEquals("10111001.10010010.00110110.00010101", result.getIpAddressBinary());
        assertEquals("185.146.54.21",                       result.getIpAddressDecimal());

        assertEquals("11111111.11111111.11110000.00000000", result.getMaskBinary());
        assertEquals("255.255.240.0",                       result.getMaskDecimal());

        assertEquals(20,                                    result.getMaskNumber());

        assertEquals("10111001.10010010.00110000.00000000", result.getNetAddressBinary());
        assertEquals("185.146.48.0",                        result.getNetAddressDecimal());

        assertEquals("10111001.10010010.00111111.11111111", result.getBroadCastAddressBinary());
        assertEquals("185.146.63.255",                      result.getBroadCastAddressDecimal());

        assertEquals(4094,                                  result.getAmountOfHosts());

        assertEquals("10111001.10010010.00110000.00000001", result.getMinHostBinary());
        assertEquals("185.146.48.1",                        result.getMinHostDecimal());

        assertEquals("10111001.10010010.00111111.11111110", result.getMaxHostBinary());
        assertEquals("185.146.63.254",                      result.getMaxHostDecimal());

        assertEquals(NetworkClass.B,                                result.getNetworkClass());
    }
}
