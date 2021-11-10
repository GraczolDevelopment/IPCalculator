package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.api.SubnetCalculatorApi;
import org.junit.jupiter.api.Test;

public class CalculatorApiTests {

    @Test
    public void toBinaryTest() {
        SubnetCalculatorApi calculatorApi = new SubnetCalculatorApi()
                .setIpAddress("185.146.54.21")
                .setSubnetMask("255.255.240.0");

        System.out.println(calculatorApi.getIpAddressBinary());
        System.out.println(calculatorApi.getIpAddressDecimal());

        System.out.println("---------------------------------------");

        System.out.println(calculatorApi.getSubnetMaskBinary());
        System.out.println(calculatorApi.getSubnetMaskDecimal());

        System.out.println("---------------------------------------");

        System.out.println(calculatorApi.getSubnetMaskNumber());

        System.out.println("---------------------------------------");

        System.out.println(calculatorApi.getNetAddressBinary());
        System.out.println(calculatorApi.getNetAddressDecimal());

        System.out.println("---------------------------------------");

        System.out.println(calculatorApi.getBroadcastAddressBinary());
        System.out.println(calculatorApi.getBroadcastAddressDecimal());

        System.out.println("---------------------------------------");

        System.out.println(calculatorApi.getAmountOfHosts());

        System.out.println("---------------------------------------");

        System.out.println(calculatorApi.getMinHostBinary());
        System.out.println(calculatorApi.getMinHostDecimal());

        System.out.println("---------------------------------------");

        System.out.println(calculatorApi.getMaxHostBinary());
        System.out.println(calculatorApi.getMaxHostDecimal());

        System.out.println(calculatorApi.getNetworkClass());
    }
}
