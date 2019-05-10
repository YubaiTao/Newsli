package com.yubaitao.newsli.profile;

import java.util.HashMap;
import java.util.Map;

public class CountryEvent {
    public String country;

    /**
     * TODO: Modify here to support more language
     */
    private static final Map<String, String> COUNTRY_MAP = new HashMap<String, String>() {{
        put("China", "cn");
        put("Germany", "de");
        put("United States", "us");
        put("Japan", "jp");
    }};

    CountryEvent(String country) {
        this.country = COUNTRY_MAP.get(country);
//        this.country = country;
    }
}
