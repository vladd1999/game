package com.example.demo.model;

import java.util.ArrayList;
public class PlayerModel {

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;
    private static ArrayList<CardModel> hand = new ArrayList<>();

    public PlayerModel(int id, String name) {
        this.id= id;
        this.name = name;
    }
    public PlayerModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<CardModel> getHand() {
        return hand;
    }

    public void setHand(ArrayList<CardModel> hand) {
        this.hand = hand;
    }


}

