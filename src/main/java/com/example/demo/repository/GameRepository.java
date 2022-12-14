package com.example.demo.repository;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class GameRepository {
    private static ConcurrentHashMap<Integer, GameModel> gameMap = new ConcurrentHashMap<>();
    private static int id = 0;
    private static int playerId = 0;

    public GameModel getGame(int id) {
        return gameMap.get(id)
                ;
    }

    public GameModel createGame() {
        GameModel newGameModel = new GameModel(++id);
        gameMap.put(id, newGameModel);


        return newGameModel;
    }

    public PlayerSession joinGame(String name) {
        GameModel gameModel = gameMap.get(id)
                ;
        if (gameModel != null && gameModel.getMaxPlayer() > gameModel.getPlayers().size()) {
            gameModel.setPlayers(new PlayerModel(++playerId, name));
            if (gameModel.getMaxPlayer() == gameModel.getPlayers().size()) {
                gameModel.setCurrentPlayerId(gameModel.getPlayers().get(0).getId());
                gameModel.setTypeOfMove(TypeOfMove.pickHand);
            }
        } else {
            createGame().setPlayers(new PlayerModel(++playerId, name));
        }
        PlayerSession playerSession = new PlayerSession(id, playerId);
        return playerSession;
    }

    public GameStateModel getGameSession(PlayerSession playerSession) {
        return new GameStateModel(gameMap.get(playerSession.getId()), playerSession.getPlayerId());
    }

}