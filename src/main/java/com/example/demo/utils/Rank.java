package com.example.demo.utils;

public enum Rank {
    TWO(1),
    THREE(2),
    FOUR(3),
    FIVE(4),
    SIX(5),
    SEVEN(6),
    EIGHT(7),
    NINE(8),
    TEN(9),
    JACK(10),
    QUEEN(11),
    KING(12),
    ACE(13);

    private final int rankValue;
    Rank(final int rankValue) {
        this.rankValue = rankValue;
    }

    public int getRankValue() {
        return this.rankValue;
    }
}