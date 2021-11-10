package com.graczdev.ipcalculator.api;

import com.graczdev.ipcalculator.calculator.AddressType;
import com.graczdev.ipcalculator.calculator.IPAddress;
import com.graczdev.ipcalculator.calculator.IPMask;
import com.graczdev.ipcalculator.calculator.NetworkUtils;

public class CalculatorService {

    private IPAddress address;
    private IPAddress mask;
    private String[] ipAddressDecimal = {"0", "0", "0", "0"};
    private String[] subnetMaskDecimal = {"0", "0", "0", "0"};

    private String[] ipAddressBinary = {"00000000", "00000000", "00000000", "00000000"};
    private String[] subnetMaskBinary = {"00000000", "00000000", "00000000", "00000000"};

    private int subnetMaskNumber = 0;

    CalculatorService() {}

    void setIpAddress(String ipAddressDecimal) {
        String[] ipAddressArr = ipAddressDecimal.split("\\.");
        this.address = new IPAddress(ipAddressDecimal);
        this.ipAddressDecimal = ipAddressArr;
        this.ipAddressBinary = NetworkUtils.toBinary(ipAddressArr);
    }

     void setSubnetMask(String subnetMaskDecimal) {
        String[] subnetMask = subnetMaskDecimal.split("\\.");
        this.mask = new IPAddress(subnetMaskDecimal);
        this.subnetMaskDecimal = subnetMask;
        this.subnetMaskBinary = NetworkUtils.toBinary(subnetMask);
        this.subnetMaskNumber = String.join("", subnetMaskBinary).lastIndexOf("1") + 1;
    }

    public String getIpAddressDecimal() {
        return String.join(".", ipAddressDecimal);

    }

    public String getSubnetMaskDecimal() {
        return String.join(".", subnetMaskDecimal);
    }

    public String getIpAddressBinary() {
        return String.join(".", ipAddressBinary);
    }

    public String getSubnetMaskBinary() {
        return String.join(".", subnetMaskBinary);
    }

    public int getSubnetMaskNumber() {
        return this.subnetMaskNumber;
    }

    public String getNetAddress() {
        return NetworkUtils.makeAddress(address, IPMask.MASK_0, AddressType.NETWORK).decimal().joinDot();
    }

    public String getBroadcastAddress() {
        return NetworkUtils.makeAddress(address, IPMask.MASK_0, AddressType.BROADCAST).decimal().joinDot();
    }

    public int getAmountOfHosts() {
        int numberOfHosts = (int) Math.pow(2, 32 - subnetMaskNumber) - 2;

        return Math.max(numberOfHosts, 0);
    }

    public String getMinHost() {
        final String netAddress = this.getNetAddress();
        return netAddress.substring(0, netAddress.length() - 1) + "1";
    }

    public String getMaxHost() {
        final String broadcastAddress = this.getBroadcastAddress();
        return broadcastAddress.substring(0, broadcastAddress.length() - 1) + "0";
    }

    public String getNetworkClass() {
        int firstOctet = Integer.parseInt(this.ipAddressDecimal[0]);

        if (firstOctet < 127) {
            return "A";
        }

        if (firstOctet < 192) {
            return "B";
        }

        if (firstOctet < 224) {
            return "C";
        }

        if (firstOctet < 240) {
            return "D";
        }

        return "E";
    }
}
