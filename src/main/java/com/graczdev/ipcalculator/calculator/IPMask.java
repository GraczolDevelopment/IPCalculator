package com.graczdev.ipcalculator.calculator;

public enum IPMask {

    MASK_0(0);

    private final int cidr;
    private final IPAddress address;
    private final int hostCount;

    IPMask(int cidr) {
        this.cidr = cidr;
        this.address = NetworkUtils.cidrToIPAddress(cidr);
        this.hostCount = Math.max((int) Math.pow(2, 32 - cidr) - 2, 0);
    }

    public int getCidr() {
        return cidr;
    }

    public IPAddress getAddress() {
        return address;
    }

    public int getHostCount() {
        return hostCount;
    }

//    public static IPMask getByCidr(int cird) {
//
//    }

}
