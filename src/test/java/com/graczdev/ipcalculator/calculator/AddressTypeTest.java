package com.graczdev.ipcalculator.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//hehe..
public class AddressTypeTest {

    @Test
    public void bitZero() {
        assertEquals(Bit.ZERO, AddressType.NETWORK.getFill());
    }

    @Test
    public void bitOne() {
        assertEquals(Bit.ONE, AddressType.BROADCAST.getFill());
    }

}
