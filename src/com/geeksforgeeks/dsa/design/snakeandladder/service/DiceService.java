package com.geeksforgeeks.dsa.design.snakeandladder.service;

import java.util.Random;

public class DiceService {

    //service which will be used to get the dice roll outcome

    public static int rollDice() {
        return new Random().nextInt(6) + 1;
    }
}
