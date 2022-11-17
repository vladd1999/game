package com.example.demo;

import com.example.demo.model.Card;
import com.example.demo.model.PokerHandEvaluator;
import com.example.demo.utils.Rank;
import com.example.demo.utils.Suit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;


class AppApplicationTests {


    PokerHandEvaluator evaluator;
    Card card1;
    Card card2;
    Card card3;
    Card card4;
    Card card5;
    Card card6;
    Card card7;
    Card card8;
    Card card9;
    Card card10;
    Card card11;
    ArrayList<Card> hand;

    @BeforeEach
    public void before() {
        evaluator = new PokerHandEvaluator();
        card1 = new Card(Suit.CLUBS, Rank.EIGHT);
        card2 = new Card(Suit.HEARTS, Rank.EIGHT);
        card3 = new Card(Suit.SPADES, Rank.QUEEN);
        card4 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        card5 = new Card(Suit.CLUBS, Rank.ACE);
        card6 = new Card(Suit.HEARTS, Rank.FIVE);
        card7 = new Card(Suit.SPADES, Rank.SIX);
        card8 = new Card(Suit.CLUBS, Rank.TEN);
        card9 = new Card(Suit.CLUBS, Rank.JACK);
        card10 = new Card(Suit.CLUBS, Rank.QUEEN);
        card11 = new Card(Suit.CLUBS, Rank.KING);
        hand = new ArrayList<>();
    }

    @Test
    public void testHighCard() {
        Collections.addAll(hand, card1, card2, card3, card4, card5);
        Assertions.assertEquals(card5, evaluator.highCard(hand));
    }

}