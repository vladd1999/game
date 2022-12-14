package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class GameStateModel {
    private int id;
    private int maxPlayer = 2;
    private ArrayList<PlayerInfoModel> players;
    private Integer currentPlayerId;// if null => game didnt start yet
    private TypeOfMove typeOfMove = TypeOfMove.waiting; //0-not your turn, 1- pick hand, 2- trust or not
    private List<CardModel> tableCardModels;
    private List<CardModel> myCardModels;
    private InformationModel lastInfo;
    public GameStateModel(){

    }
    public GameStateModel(GameModel gameModel, int playerId) {
        id = gameModel.getId();
        players = new ArrayList<>();


        for (PlayerModel playerModel : gameModel.getPlayers()) {
            players.add(new PlayerInfoModel(playerModel.getId(), playerModel.getName(), playerModel.getHand().size()));
            if (playerModel.getId() == playerId) {
                myCardModels = playerModel.getHand();
            }
        }
        tableCardModels = gameModel.getTableCards();
        currentPlayerId = gameModel.getCurrentPlayerId();
        if (gameModel.getCurrentPlayerId()!=null && gameModel.getCurrentPlayerId() == playerId) {

            typeOfMove = gameModel.getTypeOfMove();
            lastInfo = gameModel.getLastInformation();
        }
    }

    public Integer getCurrentPlayerId() {
        return currentPlayerId;
    }

    public void setCurrentPlayerId(Integer currentPlayerId) {
        this.currentPlayerId = currentPlayerId;
    }

    public TypeOfMove getTypeOfMove() {
        return typeOfMove;
    }
    public InformationModel getLastInfo() {
        return lastInfo;
    }

    public void setTypeOfMove(TypeOfMove typeOfMove) {
        this.typeOfMove = typeOfMove;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", maxPlayer=" + maxPlayer +
                ", players=" + players +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getMaxPlayer() {
        return maxPlayer;
    }

    public List<PlayerInfoModel> getPlayers() {
        return players;
    }

    public void setPlayers(PlayerInfoModel player) {
        this.players.add(player);
    }
}
