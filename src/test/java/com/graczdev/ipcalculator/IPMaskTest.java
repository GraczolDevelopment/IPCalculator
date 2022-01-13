package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.calculator.IPMask;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IPMaskTest {

    @Test
    public void addressTest() {
        testMask("255.255.255.255", 1L,          IPMask.MASK_32);
        testMask("255.255.255.254", 2L,          IPMask.MASK_31);
        testMask("255.255.255.252", 2L,          IPMask.MASK_30);
        testMask("255.255.255.248", 6L,          IPMask.MASK_29);
        testMask("255.255.255.240", 14L,         IPMask.MASK_28);
        testMask("255.255.255.224", 30L,         IPMask.MASK_27);
        testMask("255.255.255.192", 62L,         IPMask.MASK_26);
        testMask("255.255.255.128", 126L,        IPMask.MASK_25);
        testMask("255.255.255.0",   254L,        IPMask.MASK_24);
        testMask("255.255.254.0",   510L,        IPMask.MASK_23);
        testMask("255.255.252.0",   1022L,       IPMask.MASK_22);
        testMask("255.255.248.0",   2046L,       IPMask.MASK_21);
        testMask("255.255.240.0",   4094L,       IPMask.MASK_20);
        testMask("255.255.224.0",   8190L,       IPMask.MASK_19);
        testMask("255.255.192.0",   16382L,      IPMask.MASK_18);
        testMask("255.255.128.0",   32766L,      IPMask.MASK_17);
        testMask("255.255.0.0",     65534L,      IPMask.MASK_16);
        testMask("255.254.0.0",     131070L,     IPMask.MASK_15);
        testMask("255.252.0.0",     262142L,     IPMask.MASK_14);
        testMask("255.248.0.0",     524286L,     IPMask.MASK_13);
        testMask("255.240.0.0",     1048574L,    IPMask.MASK_12);
        testMask("255.224.0.0",     2097150L,    IPMask.MASK_11);
        testMask("255.192.0.0",     4194302L,    IPMask.MASK_10);
        testMask("255.128.0.0",     8388606L,    IPMask.MASK_9);
        testMask("255.0.0.0",       16777214L,   IPMask.MASK_8);
    }

    private void testMask(String address, long hostCount, IPMask mask) {
        assertEquals(address, mask.getAddress().getOriginal());
        assertEquals(hostCount, mask.getHostCount());
    }

}
