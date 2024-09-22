package com.reviewcode.tool.utils;

import lombok.experimental.UtilityClass;

import java.util.Optional;

@UtilityClass
public class EnvUtils {
    public static String getEnv(String key) {
        return Optional.ofNullable(System.getenv(key)).orElseThrow(()
                -> new IllegalArgumentException("Environment variable " + key + " is not set"));
    }
}
