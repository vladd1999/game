package com.example.demo.model;

import com.example.demo.utils.Rank;
import com.example.demo.utils.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;


public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        newDeck();
        shuffle();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void add(Card card) {
        deck.add(card);
    }

    public Card get(int index) {
        return deck.get(index);
    }

    public Card remove(int index) {
        return deck.remove(index);
    }

    public int size() {
        return deck.size();
    }

    public void clear() {
        deck.clear();
    }

    public void newDeck() {
        Card card;

        ArrayList<Card> deck = new ArrayList<Card>();

        ArrayList<Suit> suits =
                new ArrayList<Suit>(EnumSet.allOf(Suit.class));

        ArrayList<Rank> cardTypes =
                new ArrayList<Rank>(EnumSet.allOf(Rank.class));

        for(Suit suit : suits) {
            for (Rank value : cardTypes) {
                card = new Card(suit, value);
                deck.add(card);
            }
        }

        this.deck = deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }



}
