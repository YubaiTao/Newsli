package com.yubaitao.newsli.common;

public class Util {
    private Util() {

    }

    public static boolean isStringEmpty(String string) {
        return string == null || string.length() == 0;
    }
}
