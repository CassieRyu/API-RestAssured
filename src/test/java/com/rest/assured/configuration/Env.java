package com.rest.assured.configuration;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Env {
    private static final String CURRENT_ENV = System.getProperty("env");
    private static final Map<String, String> ENV_PARIS = ImmutableMap.of(
            "local", "https://localhost:8080",
            "dev", "https://dev.bff.api/",
            "prod", "https://ghibliapi.herokuapp.com"
    );

    public static String getBaseURL() {
        return ENV_PARIS.getOrDefault(CURRENT_ENV, "https://ghibliapi.herokuapp.com");
    }
}
