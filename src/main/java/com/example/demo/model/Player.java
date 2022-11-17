package com.example.demo.model;

import java.util.ArrayList;
public class Player {

    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        hand.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }


}
//public class Player {
//    private int id;
//    private String name;
//    private ArrayList<Card> hand;
//    private Integer cardNum;
//
//    public Player(String name) {
//        this.name = name;
//        this.hand = new ArrayList<Card>(cardNum);
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Integer getCardNum() {
//        return cardNum;
//    }
//
//    public void setCardNum(Integer cardNum) {
//        this.cardNum = cardNum;
//    }
//
//    public ArrayList<Card> getHand() {
//        return hand;
//    }
//
//    public void setHand(ArrayList<Card> hand) {
//        this.hand = hand;
//    }
//
//}
