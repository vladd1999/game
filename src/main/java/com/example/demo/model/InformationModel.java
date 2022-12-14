package com.example.demo.model;

import com.example.demo.utils.PokerHandPower;

public class InformationModel {
    private PokerHandPower pokerHandPower;
    private int value;
    private Integer secondValue;//if is 2c2c or 3c2c


    public InformationModel(PokerHandPower pokerHandPower, int value, Integer secondValue) {
        this.pokerHandPower = pokerHandPower;
        this.value = value;
        this.secondValue = secondValue;
    }

    public InformationModel() {
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

    public Integer getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Integer secondValue) {
        this.secondValue = secondValue;
    }

    public boolean greaterThan(InformationModel actualInformation) {
        return actualInformation == null
                || (this.pokerHandPower.ordinal() > actualInformation.pokerHandPower.ordinal())
                || (this.pokerHandPower.ordinal() == actualInformation.pokerHandPower.ordinal()
                && (this.value > actualInformation.value
                || (this.value == actualInformation.value && this.secondValue > actualInformation.secondValue)));
    }
}
