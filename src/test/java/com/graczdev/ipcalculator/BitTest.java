package com.graczdev.ipcalculator;

import com.graczdev.ipcalculator.calculator.Bit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Yes, xDD
public class BitTest {

    @Test
    public void bitZero() {
        assertEquals("0", Bit.ZERO);
    }

    @Test
    public void bitOne() {
        assertEquals("1", Bit.ONE);
    }

}
