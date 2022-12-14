package com.example.demo.model;

public class PlayerInfoModel {
    private int id;
    private String name;
    private int numberOfCards;

    public PlayerInfoModel(int id, String name, int numberOfCards) {
        this.id = id;
        this.name = name;
        this.numberOfCards = numberOfCards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfCards() {
        return numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) {
        this.numberOfCards = numberOfCards;
    }
}
