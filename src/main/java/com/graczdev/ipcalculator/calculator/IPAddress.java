package com.graczdev.ipcalculator.calculator;

import panda.std.Option;
import panda.std.Quad;
import panda.utilities.StringUtils;
import panda.utilities.text.Joiner;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddress {

    private final InetAddress address;
    private final String original;
    private final AddressParts decimalParts;
    private final AddressParts binaryParts;

    public IPAddress(String address) {
        this.address = Option.attempt(UnknownHostException.class, () -> InetAddress.getByName(address))
                .orThrow(() -> new RuntimeException(address + " isn't IP address!"));
        this.original = address;
        this.decimalParts = AddressParts.of(original.split("\\."));
        this.binaryParts = AddressParts.of(NetworkUtils.toBinary(original.split("\\.")));
    }

    public InetAddress getAddress() {
        return address;
    }

    public String getOriginal() {
        return original;
    }

    public AddressParts decimal() {
        return decimalParts;
    }

    public AddressParts binary() {
        return binaryParts;
    }

    public IPAddress make(AddressType type, IPMask mask) {
        return NetworkUtils.makeAddress(this, mask, type);
    }

    public AddressParts getMinHost(IPMask mask) {
        String network = make(AddressType.NETWORK, mask).binaryParts.joinDot();
        String result = network.substring(0, network.length() - 1) + AddressType.BROADCAST.getFill();

        return AddressParts.of(result.split("\\."));
    }

    public AddressParts getMaxHost(IPMask mask) {
        String broadcast = make(AddressType.BROADCAST, mask).binaryParts.joinDot();
        String result = broadcast.substring(0, broadcast.length() - 1) + AddressType.NETWORK.getFill();

        return AddressParts.of(result.split("\\."));
    }

    public static class AddressParts extends Quad<String, String, String, String> {

        public AddressParts(String first, String second, String third, String fourth) {
            super(first, second, third, fourth);
        }

        public static AddressParts of(String[] parts) {
            return new AddressParts(parts[0], parts[1], parts[2], parts[3]);
        }

        public String join() {
            return join(StringUtils.EMPTY);
        }

        public String joinDot() {
            return join(".");
        }

        public String join(String separator) {
            return Joiner.on(separator).join(this.getFirst(), this.getSecond(), this.getThird(), this.getFourth()).toString();
        }

    }

}
