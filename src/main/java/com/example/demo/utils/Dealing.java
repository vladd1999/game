package com.example.demo.utils;
import com.example.demo.model.Card;
import com.example.demo.model.Player;

import java.util.ArrayList;


public interface Dealing {

    void deal(int cardsPerPlayer, ArrayList<Player> players);

    void dealTable(int numberOfCards, ArrayList<Card> table);

}