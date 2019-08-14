package com.kata.bankocr;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Digits {
    public static final List<String> ZERO = Collections.unmodifiableList(Arrays.asList(
        " _ ",
        "| |",
        "|_|",
        "   "
    ));

    public static final List<String> ONE = Collections.unmodifiableList(Arrays.asList(
        "   ",
        "  |",
        "  |",
        "   "
    ));

    public static final List<String> TWO = Collections.unmodifiableList(Arrays.asList(
        " _ ",
        " _|",
        "|_ ",
        "   "
    ));

    public static final List<String> THREE = Collections.unmodifiableList(Arrays.asList(
        " _ ",
        " _|",
        " _|",
        "   "
    ));
}