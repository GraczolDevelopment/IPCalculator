package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.calculator.AddressType;
import com.graczdev.ipcalculator.calculator.Bit;
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
