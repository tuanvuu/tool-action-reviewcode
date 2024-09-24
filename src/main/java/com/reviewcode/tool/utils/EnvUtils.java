package com.reviewcode.tool.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class EnvUtils {
    public static String getEnv(String key) {
        return System.getenv(key);
    }
}
