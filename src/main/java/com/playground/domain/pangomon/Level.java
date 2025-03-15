package com.playground.domain.pangomon;

import static com.playground.utils.Preconditions.require;

public record Level(int value) {
    private static final int EXPERIENCE_FACTOR = 100;

    public Level {
        require(value >= 1, "Level value can't be less than 1");
        require(value <= 100, "Level value can't be more than 100");
    }

    public Level levelUp() {
        return new Level(value + 1);
    }

    public int experienceForNextLevel() {
        return value * EXPERIENCE_FACTOR;
    }
}