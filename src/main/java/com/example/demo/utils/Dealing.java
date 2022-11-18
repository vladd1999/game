package com.example.demo.utils;
import com.example.demo.model.Card;
import com.example.demo.model.Player;

import java.util.ArrayList;
import java.util.List;


public interface Dealing {

    void deal(List<Player> players);

    void dealTable(List<Card> table);

}