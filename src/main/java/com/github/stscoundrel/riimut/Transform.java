package com.github.stscoundrel.riimut;

import java.util.HashMap;

class Transform {
    public static String withDictionary(String content, HashMap<String, String> map) {
        StringBuilder result = new StringBuilder();

        for (char letter : content.toCharArray()) {
            String part = String.valueOf(letter).toLowerCase();
            if (map.containsKey(part)) {
                result.append(map.get(part));
            } else {
                result.append(part);
            }
        }

        return result.toString();
    }
}
