package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.Information;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {
    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(path = "/{id}")
    public Game getGame(@PathVariable int id) {
        return gameService.getGame(id);
    }

    @GetMapping(path = "/db/{id}")
    public Game getGameByDB(@PathVariable int id) {
        return gameService.getGameByDB(id);
    }
    @PostMapping(value = "next-accepted-move")
    List<Information> nextAcceptedMove(int gameId){
        return gameService.nextAcceptedMove(gameId);
    }
}
