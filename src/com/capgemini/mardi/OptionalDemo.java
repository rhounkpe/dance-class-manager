package com.capgemini.mardi;

import java.util.Optional;

public class OptionalDemo {
    // Boxing Aut
    public static Optional<Double> average(int... scores) {
        if (scores.length == 0) {
            return Optional.empty();
        }

        int total = 0;

        for (int score : scores) {
            total += score;
        }
        return Optional.of((double) total / scores.length);
    }
}
