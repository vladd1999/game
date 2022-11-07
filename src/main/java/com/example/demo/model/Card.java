package com.example.demo.model;

public class Card {
    private int id;
    private String suits;

    public void setId(int id) {
        this.id = id;
    }

    public void setSuits(String suits) {
        this.suits = suits;
    }

    public int getId() {
        return id;
    }

    public String getSuits() {
        return suits;
    }

    public Card(String suits) {
        this.suits = suits;
    }

    public Card(int id) {
        this.id = id;
    }
}
