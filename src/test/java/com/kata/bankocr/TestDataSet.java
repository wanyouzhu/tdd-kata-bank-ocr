package com.kata.bankocr;

import static org.apache.commons.lang3.StringUtils.join;

public class TestDataSet {
    public static String lines(String... values) {
        return join(values, "\n");
    }
}
