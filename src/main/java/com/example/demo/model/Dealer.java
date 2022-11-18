package com.example.demo.model;
import com.example.demo.utils.Dealing;

import java.util.ArrayList;
import java.util.List;

public class Dealer implements Dealing {

    Deck deck;

    public Dealer() {
        this.deck = new Deck();
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public Card drawCard(int index) {

        Card card = getCard(index);
        deck.remove(index);
        return card;
    }

    public void dealCard(Player player, Card card) {
        player.getHand().add(card);

    }

    public void deal(List<Player> players) {
        players.forEach(player->{
            for (int i = 0; i < player.getHand().size(); i++) {
                Card card = drawCard(0);
                dealCard(player, card);
            }});
    }

    public void dealTable(List<Card> table) {
        for (int i = 0; i < 5; i++) {
            Card card = drawCard(0);
            table.add(card);
        }
    }
}