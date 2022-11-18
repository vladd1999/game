package com.example.demo.service;


import com.example.demo.model.Card;
import com.example.demo.model.Game;
import com.example.demo.model.Information;
import com.example.demo.model.Player;
import com.example.demo.serviceDao.GameServiceDao;
import com.example.demo.utils.PokerHandPower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class GameService {
    private static HashMap<Integer, Game> gameMap = new HashMap<>();

    static {
        gameMap.put(1, new Game(1, "qaqqqqq", 4, null, null, null));
        gameMap.put(2, new Game(2, "qsqqqqq", 4, null, null, null));
        gameMap.put(3, new Game(3, "qdqqqqq", 4, null, null, null));
        gameMap.put(4, new Game(4, "qcqqqqq", 4, null, null, null));
        gameMap.put(5, new Game(5, "qvqqqqq", 4, null, null, null));
        gameMap.put(6, new Game(6, "qbqqqqq", 4, null, null, null));
    }

    private GameServiceDao gameServiceDao;

    @Autowired
    public GameService(GameServiceDao gameServiceDao) {
        this.gameServiceDao = gameServiceDao;
    }

    public Game getGame(int id) {
        return gameMap.get(id);
    }
//    public boolean gameLogic(int[] allCardsInGame, Information info){
//
//    }

    public Game CreateGame(String passwordGame, int maxPlayer, Player gameOwner, List<Player> players) {
        int id = gameMap.size() + 1;
        int[] allCardsInGame = new int[13];
        Game newGame = new Game();
        newGame.dealer.getDeck().newDeck();
        newGame.dealer.getDeck().shuffle();
        gameMap.put(id, newGame);
        ArrayList<Card> tableCards = new ArrayList<>();
        Game.dealer.dealTable(tableCards);
        Game.dealer.deal(players);
        tableCards.forEach(card -> getAllCards(allCardsInGame, card));


        return newGame;
    }

    public void getAllCards(int[] allCardsInGame, Card card) {
        allCardsInGame[card.getRank().ordinal()]++;
    }

    public Game getGameByDB(int id) {
        return gameServiceDao.selectGame(id);
    }

    public List<Information> nextAcceptedMove(int gameId) {
        Game game = gameMap.get(gameId);
        ArrayList<Information> informations = new ArrayList<>();
        Information lastGameInfo = game.getLastInformation();
        if (lastGameInfo.getValue() < 12) {
            if (lastGameInfo.getSecondValue() != 0) {
                informations.add(new Information(lastGameInfo.getPokerHandPower(), lastGameInfo.getValue() + 1, lastGameInfo.getSecondValue() + 1));
            } else {
                informations.add(new Information(lastGameInfo.getPokerHandPower(), lastGameInfo.getValue() + 1, 0));
            }
        }
        PokerHandPower[] pokerHandPower = PokerHandPower.values();
        for (int i = game.getLastInformation().getPokerHandPower().ordinal() + 1; i < pokerHandPower.length; i++) {
            informations.add(new Information(pokerHandPower[i], 0, 0));
        }
        return informations;
    }
}
//{
//HandPower : 2
//value:3
//secondValue:2