package com.google.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {
    private ConfigurationManager() {
    }

    public static Configurations config() {
        return ConfigCache.getOrCreate(Configurations.class);
    }
}
