package com.example.demo.Util;

import java.util.UUID;

public class PatternUtil {

    public static final String CAR_ID_PREFIX = "CAR-";
    public static final String UUID_REGEX = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
    public static final String CAR_ID_REGEX = CAR_ID_PREFIX + UUID_REGEX;


    public static String generateId()
    {
        return CAR_ID_PREFIX + UUID.randomUUID().toString();

    }

}
