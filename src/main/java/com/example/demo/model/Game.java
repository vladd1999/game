package com.example.demo.model;

import java.util.List;

public class Game {
    private int id;
    private String passwordGame;
    private int maxPlayer;
    private Player gameOwner;
    private List<Card> cards;
    private List<Player> players;
    public Game(){

    }
    public Game(int id, String passwordGame, int maxPlayer, Player gameOwner, List<Card> cards, List<Player> players) {
        this.id = id;
        this.passwordGame = passwordGame;
        this.maxPlayer = maxPlayer;
        this.gameOwner = gameOwner;
        this.cards = cards;
        this.players = players;
    }
    public static Game of(int id, String passwordGame, int maxPlayer, Player gameOwner){
        return null;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", passwordGame='" + passwordGame + '\'' +
                ", maxPlayer=" + maxPlayer +
                ", gameOwner=" + gameOwner +
                ", cards=" + cards +
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
