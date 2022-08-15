package com.geeksforgeeks.dsa.design.snakeandladder.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SnakeAndLadderBoard {

    private int size;//holds the size of the board
    private List<Snake> snakesList;
    private List<Ladder> laddersList;
    private Map<String, Integer> playerPieces;

    public SnakeAndLadderBoard(int size) {
        this.size = size;
        this.snakesList = new ArrayList<>();
        this.laddersList = new ArrayList<>();
        this.playerPieces = new HashMap<>();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Snake> getSnakesList() {
        return snakesList;
    }

    public void setSnakesList(List<Snake> snakesList) {
        this.snakesList = snakesList;
    }

    public List<Ladder> getLaddersList() {
        return laddersList;
    }

    public void setLaddersList(List<Ladder> laddersList) {
        this.laddersList = laddersList;
    }

    public Map<String, Integer> getPlayerPieces() {
        return playerPieces;
    }

    public void setPlayerPieces(Map<String, Integer> playerPieces) {
        this.playerPieces = playerPieces;
    }
}
