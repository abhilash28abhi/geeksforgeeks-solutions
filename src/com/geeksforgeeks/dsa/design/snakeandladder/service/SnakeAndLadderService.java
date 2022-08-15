package com.geeksforgeeks.dsa.design.snakeandladder.service;

import com.geeksforgeeks.dsa.design.snakeandladder.models.Ladder;
import com.geeksforgeeks.dsa.design.snakeandladder.models.Player;
import com.geeksforgeeks.dsa.design.snakeandladder.models.Snake;
import com.geeksforgeeks.dsa.design.snakeandladder.models.SnakeAndLadderBoard;

import java.util.*;

public class SnakeAndLadderService {

    private SnakeAndLadderBoard board;
    private int initialNumberOfPlayers;
    private Queue<Player> playerQueue;
    private int numberOfDices;
    private boolean shouldGameContinueTillLastPlayer;
    private boolean shouldAllowMultipleDiceRollOnSix;


    private static final int DEFAULT_BOARD_SIZE = 100; //The board will have 100 cells numbered from 1 to 100.
    private static final int DEFAULT_NO_OF_DICES = 1;

    public SnakeAndLadderService(int boardSize) {
        this.board = new SnakeAndLadderBoard(boardSize);
        this.playerQueue = new LinkedList<Player>();
        this.numberOfDices = SnakeAndLadderService.DEFAULT_NO_OF_DICES;
    }

    public SnakeAndLadderService() {
        this(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
    }

    public void setSnakes(List<Snake> snakes) {
        this.board.setSnakesList(snakes);
    }

    public void setLadder(List<Ladder> ladders) {
        this.board.setLaddersList(ladders);
    }

    public void setShouldGameContinueTillLastPlayer(boolean shouldGameContinueTillLastPlayer) {
        this.shouldGameContinueTillLastPlayer = shouldGameContinueTillLastPlayer;
    }

    public void setShouldAllowMultipleDiceRollOnSix(boolean shouldAllowMultipleDiceRollOnSix) {
        this.shouldAllowMultipleDiceRollOnSix = shouldAllowMultipleDiceRollOnSix;
    }

    private int getTotalValueAfterDiceRolls() {
        return DiceService.rollDice();
    }

    private boolean isGameCompleted() {
        // Can use shouldGameContinueTillLastPlayer to change the logic
        // of determining if game is completed
        int currentNumberOfPlayers = playerQueue.size();
        return currentNumberOfPlayers < initialNumberOfPlayers;
    }

    public void setPlayerQueue (List<Player> players) {
        this.initialNumberOfPlayers = players.size();
        this.playerQueue = new LinkedList<>();
        Map<String, Integer> playerPieces = new HashMap<>();

        players.stream().forEach(e -> {
            playerQueue.add(e);
            playerPieces.put(e.getPlayerId(), 0);
        });
        board.setPlayerPieces(playerPieces);
    }

    private boolean hasPlayerWon(Player currentPlayer) {
        return board.getPlayerPieces().get(currentPlayer.getPlayerId()) == this.board.getSize() ?
                true : false;
    }

    private void movePlayer(Player currentPlayer, int totalDiceValue) {
        int oldPosition = board.getPlayerPieces().get(currentPlayer.getPlayerId());
        int newPosition = oldPosition + totalDiceValue;
        int boardSize = board.getSize();

        if (newPosition > boardSize) {
            newPosition = oldPosition;// don't move that player
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }

        board.getPlayerPieces().put(currentPlayer.getPlayerId(), newPosition);
    }

    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : board.getSnakesList()) {
                if (snake.getStart() == newPosition) {
                    newPosition = snake.getEnd();
                }
            }

            for (Ladder ladder : board.getLaddersList()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd();
                }
            }
        } while (newPosition != previousPosition);

        return newPosition;
    }

    public void startGame() {
        while (!isGameCompleted()) {
            // Each player rolls the dice when their turn comes
            int totalDiceValue = getTotalValueAfterDiceRolls();
            Player currentPlayer = playerQueue.poll();
            movePlayer(currentPlayer, totalDiceValue);

            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getPlayerName() + " wins the game");
                board.getPlayerPieces().remove(currentPlayer.getPlayerId());
            } else {
                playerQueue.add(currentPlayer);
            }
        }
    }
}
