package com.example.demo.utils;

public enum PokerHandPower {
    HIGHCARD,
    PAIR,
    TWOPAIRS,
    THREEOFAKIND,
    STRAIGHT,
    FULLHOUSE,
    FOUROFAKIND,
    STRAIGHTFLUSH,
    ROYALFLUSH;

    public int getOrdinal() {
        return this.ordinal();
    }
}
