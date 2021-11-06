package com.graczdev.ipcalculator.api;

public class SubnetCalculatorApi {

    private final CalculatorService calculatorService;

    public SubnetCalculatorApi() {
        calculatorService = new CalculatorService();
    }

    public SubnetCalculatorApi setIpAddress(String ipAddress) {
        calculatorService.setIpAddress(ipAddress);
        return this;
    }

    public SubnetCalculatorApi setSubnetMask(String subnetMask) {
        calculatorService.setSubnetMask(subnetMask);
        return this;
    }

    public String getIpAddressDecimal() {
        return calculatorService.getIpAddressDecimal();
    }

    public String getIpAddressBinary() {
        return calculatorService.getIpAddressBinary();
    }

    public String getSubnetMaskDecimal() {
        return calculatorService.getSubnetMaskDecimal();
    }

    public String getSubnetMaskBinary() {
        return calculatorService.getSubnetMaskBinary();
    }

    public String getSubnetMaskNumber() {
        return String.valueOf(calculatorService.getSubnetMaskNumber());
    }

    public String getNetAddressDecimal() {
        return CalculatorUtils.toDecimal(calculatorService.getNetAddress());
    }

    public String getNetAddressBinary() {
        return calculatorService.getNetAddress();
    }

    public String getBroadcastAddressBinary() {
        return calculatorService.getBroadcastAddress();
    }

    public String getBroadcastAddressDecimal() {
        return CalculatorUtils.toDecimal(calculatorService.getBroadcastAddress());
    }

    public String getAmountOfHosts() {
        return String.valueOf(calculatorService.getAmountOfHosts());
    }

    public String getMinHostBinary() {
        return calculatorService.getMinHost();
    }

    public String getMinHostDecimal() {
        return CalculatorUtils.toDecimal(calculatorService.getMinHost());
    }

    public String getMaxHostBinary() {
        return calculatorService.getMaxHost();
    }

    public String getMaxHostDecimal() {
        return CalculatorUtils.toDecimal(calculatorService.getMaxHost());
    }

    public String getNetworkClass() {
        return calculatorService.getNetworkClass();
    }
}
