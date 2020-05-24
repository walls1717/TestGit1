package com.cj.test.fundamentals5_12;

/**
 * 大小
 * @author CJ
 */
public enum Size {
    //定义大小
    SMALL("S"), MEDIUM("M"), LARGE("L"), EXTRA_LARGE("XL");

    private final String abbreviation;

    private Size(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
