package com.graczdev.ipcalculator.views.calculator;

import com.graczdev.ipcalculator.calculator.IPMask;
import lombok.Getter;
import org.hibernate.mapping.Map;
import panda.utilities.collection.Maps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GuiHelper {

    protected static final String header =          "Kalkulator IP";
    protected static final String ipAddress =       "adres IP";
    protected static final String mask =            "maska";
    protected static final String calculateButton = "Oblicz";
    protected static final List<String> masksListStrings = Arrays.asList(
            "255.255.255.255", "255.255.255.254", "255.255.255.252", "255.255.255.248",
            "255.255.255.240", "255.255.255.224", "255.255.255.192", "255.255.255.128",
            "255.255.255.0", "255.255.254.0", "255.255.252.0", "255.255.248.0",
            "255.255.240.0", "255.255.224.0", "255.255.192.0", "255.255.128.0",
            "255.255.0.0", "255.254.0.0", "255.252.0.0", "255.248.0.0",
            "255.240.0.0", "255.224.0.0", "255.192.0.0", "255.128.0.0",
            "255.0.0.0", "254.0.0.0", "252.0.0.0", "248.0.0.0",
            "240.0.0.0", "224.0.0.0", "192.0.0.0", "128.0.0.0",
            "0.0.0.0"
    );

    protected static final List<IPMask> masksListEnums = Arrays.asList(
            IPMask.MASK_32, IPMask.MASK_31, IPMask.MASK_30, IPMask.MASK_29,
            IPMask.MASK_28, IPMask.MASK_27, IPMask.MASK_26, IPMask.MASK_25,
            IPMask.MASK_24, IPMask.MASK_23, IPMask.MASK_22, IPMask.MASK_21,
            IPMask.MASK_20, IPMask.MASK_19, IPMask.MASK_18, IPMask.MASK_17,
            IPMask.MASK_16, IPMask.MASK_15, IPMask.MASK_14, IPMask.MASK_13,
            IPMask.MASK_12, IPMask.MASK_11, IPMask.MASK_10, IPMask.MASK_9,
            IPMask.MASK_8, IPMask.MASK_7, IPMask.MASK_6, IPMask.MASK_5,
            IPMask.MASK_4, IPMask.MASK_3, IPMask.MASK_2, IPMask.MASK_1,
            IPMask.MASK_0
    );
}
