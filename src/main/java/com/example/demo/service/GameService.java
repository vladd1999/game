package com.example.demo.service;


import com.example.demo.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.serviceDao.GameServiceDao;

import java.util.HashMap;

@Service
public class GameService {
    @Autowired
    public GameService(GameServiceDao gameServiceDao) {
        this.gameServiceDao = gameServiceDao;
    }

    private GameServiceDao gameServiceDao;
    private static HashMap<Integer, Game> gameMap = new HashMap<Integer, Game>();

    static {
        gameMap.put(1, new Game(1, "qaqqqqq", 4, null, null,null));
        gameMap.put(2, new Game(2, "qsqqqqq", 4, null, null,null));
        gameMap.put(3, new Game(3, "qdqqqqq", 4, null, null,null));
        gameMap.put(4, new Game(4, "qcqqqqq", 4, null, null,null));
        gameMap.put(5, new Game(5, "qvqqqqq", 4, null, null,null));
        gameMap.put(6, new Game(6, "qbqqqqq", 4, null, null,null));
    }

    public Game getGame(int id) {
        return gameMap.get(id);
    }

    public Game getGameByDB(int id) {
        return gameServiceDao.selectGame(id);
    }
}
