package com.example.demo.model;

import com.example.demo.utils.Rank;
import com.example.demo.utils.Suit;


public class CardModel {

    private Suit suit;
    private Rank rank;


    public CardModel(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

}