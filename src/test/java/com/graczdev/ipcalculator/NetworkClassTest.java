package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.calculator.IPAddress;
import com.graczdev.ipcalculator.calculator.NetworkClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NetworkClassTest {

    @Test
    public void testNetworkClassA() {
        testNetworkClass("0.0.0.0",         NetworkClass.A);
        testNetworkClass("127.255.255.255", NetworkClass.A);
    }

    @Test
    public void testNetworkClassB() {
        testNetworkClass("128.0.0.0",       NetworkClass.B);
        testNetworkClass("191.255.255.255", NetworkClass.B);
    }

    @Test
    public void testNetworkClassC() {
        testNetworkClass("192.0.0.0",       NetworkClass.C);
        testNetworkClass("223.255.255.255", NetworkClass.C);
    }

    @Test
    public void testNetworkClassD() {
        testNetworkClass("224.0.0.0",       NetworkClass.D);
        testNetworkClass("239.255.255.255", NetworkClass.D);
    }

    @Test
    public void testNetworkClassE() {
        testNetworkClass("240.0.0.0",       NetworkClass.E);
        testNetworkClass("255.255.255.255", NetworkClass.E);
    }

    private void testNetworkClass(String address, NetworkClass networkClass) {
        assertEquals(networkClass, NetworkClass.of(new IPAddress(address)));
    }

}
