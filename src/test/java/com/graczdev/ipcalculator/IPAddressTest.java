package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.calculator.IPAddress;
import com.graczdev.ipcalculator.calculator.IPMask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPAddressTest {

    private final IPAddress addressMin = new IPAddress("0.0.0.0");
    private final IPAddress addressMax = new IPAddress("255.255.255.255");
    private final IPAddress address1 = new IPAddress("65.65.0.0");
    private final IPAddress address2 = new IPAddress("65.65.000.000");
    private final IPAddress address3 = new IPAddress("65.65.65.65");

    @Test
    public void decimalTest() {
        assertEquals("0.0.0.0", addressMin.decimal().joinDot());
        assertEquals("255.255.255.255", addressMax.decimal().joinDot());
        assertEquals("65.65.0.0", address1.decimal().joinDot());
        assertEquals("65.65.0.0", address2.decimal().joinDot());
        assertEquals("65.65.65.65", address3.decimal().joinDot());
    }

    @Test
    public void binaryTest() {
        assertEquals("00000000.00000000.00000000.00000000", addressMin.binary().joinDot());
        assertEquals("11111111.11111111.11111111.11111111", addressMax.binary().joinDot());
        assertEquals("01000001.01000001.00000000.00000000", address1.binary().joinDot());
        assertEquals("01000001.01000001.00000000.00000000", address2.binary().joinDot());
        assertEquals("01000001.01000001.01000001.01000001", address3.binary().joinDot());
    }

    @Test
    public void maskMinHostTest() {
        assertEquals("0.0.0.1", addressMin.getMinHost(IPMask.MASK_10).decimal().joinDot());
        assertEquals("255.192.0.1", addressMax.getMinHost(IPMask.MASK_10).decimal().joinDot());
        assertEquals("65.64.0.1", address1.getMinHost(IPMask.MASK_10).decimal().joinDot());
        assertEquals("65.64.0.1", address2.getMinHost(IPMask.MASK_10).decimal().joinDot());
        assertEquals("65.64.0.1", address3.getMinHost(IPMask.MASK_10).decimal().joinDot());
    }

    @Test
    public void maskMaxHostTest() {
        assertEquals("0.63.255.254", addressMin.getMaxHost(IPMask.MASK_10).decimal().joinDot());
        assertEquals("255.255.255.254", addressMax.getMaxHost(IPMask.MASK_10).decimal().joinDot());
        assertEquals("65.127.255.254", address1.getMaxHost(IPMask.MASK_10).decimal().joinDot());
        assertEquals("65.127.255.254", address2.getMaxHost(IPMask.MASK_10).decimal().joinDot());
        assertEquals("65.127.255.254", address3.getMaxHost(IPMask.MASK_10).decimal().joinDot());
    }

}
