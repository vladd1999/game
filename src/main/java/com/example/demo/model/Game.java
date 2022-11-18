package com.example.demo.model;

import java.util.List;

public class Game {
    public static Dealer dealer;
    private int id;
    private String passwordGame;
    private int maxPlayer;
    private Player gameOwner;
    private List<Card> tableCards;
    private Information lastInformation = null;
    private int[] allCards = new int[13];
    private List<Player> players;
    public Game() {

    }
    public Game(int id, String passwordGame, int maxPlayer, Player gameOwner, List<Card> cards, List<Player> players) {
        this.id = id;
        this.passwordGame = passwordGame;
        this.maxPlayer = maxPlayer;
        this.gameOwner = gameOwner;
        this.tableCards = cards;
        this.players = players;

    }

    public Information getLastInformation() {
        return lastInformation;
    }

    public void setLastInformation(Information lastInformation) {
        this.lastInformation = lastInformation;
    }

    public int[] getAllCards() {
        return allCards;
    }

    public void setAllCards(int[] allCards) {
        this.allCards = allCards;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", passwordGame='" + passwordGame + '\'' +
                ", maxPlayer=" + maxPlayer +
                ", gameOwner=" + gameOwner +
                ", cards=" + tableCards +
                ", players=" + players +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswordGame() {
        return passwordGame;
    }

    public void setPasswordGame(String passwordGame) {
        this.passwordGame = passwordGame;
    }

    public int getMaxPlayer() {
        return maxPlayer;
    }

    public void setMaxPlayer(int maxPlayer) {
        this.maxPlayer = maxPlayer;
    }

    public Player getGameOwner() {
        return gameOwner;
    }

    public void setGameOwner(Player gameOwner) {
        this.gameOwner = gameOwner;
    }

    public List<Card> getTableCards() {
        return tableCards;
    }

    public void setTableCards(List<Card> tableCards) {
        this.tableCards = tableCards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
