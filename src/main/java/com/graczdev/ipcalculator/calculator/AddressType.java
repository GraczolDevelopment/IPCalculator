package com.graczdev.ipcalculator.calculator;

public enum AddressType {

    NETWORK('0'),
    BROADCAST('1');

    private final char fill;

    AddressType(char fill) {
        this.fill = fill;
    }

    public Character getFill() {
        return fill;
    }

}
