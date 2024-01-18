package com.example.monitoring_microservice.configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public abstract class MonitoringUtils {
    public static Map<String, String> convertStringToMap(String data) {
        String body = data.substring(1, data.length() - 1);
        Map<String, String> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(body, ",");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken().trim();
            String[] keyValue = token.split(":");
            map.put(keyValue[0], keyValue[1]);
        }
        return map;
    }
}