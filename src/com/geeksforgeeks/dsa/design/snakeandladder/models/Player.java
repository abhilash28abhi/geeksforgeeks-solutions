package com.geeksforgeeks.dsa.design.snakeandladder.models;

import java.util.UUID;

public class Player {

    private String playerId;
    private String playerName;

    public Player(String playerName) {
        this.playerName = playerName;
        this.playerId = UUID.randomUUID().toString();
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }
}
