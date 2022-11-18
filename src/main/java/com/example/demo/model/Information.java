package com.example.demo.model;

import com.example.demo.utils.PokerHandPower;

public class Information {
    private PokerHandPower pokerHandPower;
    private int value;
    private int secondValue;//if is 2c2c or 3c2c

    public Information(PokerHandPower pokerHandPower, int value, int secondValue) {
        this.pokerHandPower = pokerHandPower;
        this.value = value;
        this.secondValue = secondValue;
    }

    public Information() {
    }

    public PokerHandPower getPokerHandPower() {
        return pokerHandPower;
    }

    public void setPokerHandPower(PokerHandPower pokerHandPower) {
        this.pokerHandPower = pokerHandPower;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(int secondValue) {
        this.secondValue = secondValue;
    }
}
