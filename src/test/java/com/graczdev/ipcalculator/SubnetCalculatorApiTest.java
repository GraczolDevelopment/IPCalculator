package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.api.SubnetCalculatorApi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SubnetCalculatorApiTest {

    @Test
    public void TestOfSubnetCalculatorApi() {
        SubnetCalculatorApi calculatorApi = new SubnetCalculatorApi()
                .setIpAddress("185.146.54.21")
                .setSubnetMask("255.255.240.0");

        assertEquals("10111001.10010010.00110110.00010101", calculatorApi.getIpAddressBinary());
        assertEquals("185.146.54.21",                       calculatorApi.getIpAddressDecimal());

        assertEquals("11111111.11111111.11110000.00000000", calculatorApi.getSubnetMaskBinary());
        assertEquals("255.255.240.0",                       calculatorApi.getSubnetMaskDecimal());

        assertEquals("20",                                  calculatorApi.getSubnetMaskNumber());

        assertEquals("10111001.10010010.00110000.00000000", calculatorApi.getNetAddressBinary());
        assertEquals("185.146.48.0",                        calculatorApi.getNetAddressDecimal());

        assertEquals("10111001.10010010.00111111.11111111", calculatorApi.getBroadcastAddressBinary());
        assertEquals("185.146.63.255",                      calculatorApi.getBroadcastAddressDecimal());

        assertEquals("4094",                                calculatorApi.getAmountOfHosts());

        assertEquals("10111001.10010010.00110000.00000001", calculatorApi.getMinHostBinary());
        assertEquals("185.146.48.1",                        calculatorApi.getMinHostDecimal());

        assertEquals("10111001.10010010.00111111.11111110", calculatorApi.getMaxHostBinary());
        assertEquals("185.146.63.254",                      calculatorApi.getMaxHostDecimal());

        assertEquals("B",                                   calculatorApi.getNetworkClass());
    }
}
