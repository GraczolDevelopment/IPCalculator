package com.graczdev.ipcalculator.calculator;

public class CalculatorIPService {

    public AnaliseIPResult analiseIP(IPAddress address, IPMask mask) {
        int maskNumber = mask.getCidr();

//        IPAddress.AddressParts netAddress = address.make(AddressType.NETWORK, mask);
//        IPAddress.AddressParts broadCastAddress = address.make(AddressType.BROADCAST, mask);
//
//        String netAddressText = netAddress.joinDot();
//
//        netAddress.substring(0, netAddress.length() - 1) + "1";
//
//        var builder = AnaliseIPResult.builder()
//                .ipAddressDecimal(address.decimal().joinDot())
//                .ipAddressBinary(address.binary().joinDot())
//                .maskDecimal(mask.getAddress().decimal().joinDot())
//                .maskBinary(mask.getAddress().binary().joinDot())
//
//                .broadCastAddressDecimal(broadCastAddress.joinDot())
//                .broadCastAddressBinary(broadCastAddress.joinDot())
//
//                .networkClass(NetworkClass.of(address))
//                .maskNumber(maskNumber)
//                .amountOfHosts(mask.getHostCount())
//
//                .networkClass(netAddressText)
//



        return null;
    }

}
