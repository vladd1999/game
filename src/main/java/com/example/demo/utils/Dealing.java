package com.example.demo.utils;
import com.example.demo.model.CardModel;
import com.example.demo.model.PlayerModel;

import java.util.List;


public interface Dealing {

    void deal(List<PlayerModel> playerModels);

    void dealTable(List<CardModel> table);

}