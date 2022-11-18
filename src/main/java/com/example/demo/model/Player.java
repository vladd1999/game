package com.example.demo.model;

import java.util.ArrayList;
public class Player {

    private String name;
    private static ArrayList<Card> hand;

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

    public static ArrayList<Card> getHand() {
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
//    private int cardNum;
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
//    public int getCardNum() {
//        return cardNum;
//    }
//
//    public void setCardNum(int cardNum) {
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
