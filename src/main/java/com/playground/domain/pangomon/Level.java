package com.playground.domain.pangomon;

import com.playground.utils.Preconditions;

public record Level(int value) {
    private static final int EXPERIENCE_FACTOR = 100;

    public Level {
        Preconditions.require(value >= 1, "Level value can't be less than 1");
    }

    public Level levelUp() {
        return new Level(value + 1);
    }

    public int experienceForNextLevel() {
        return value * EXPERIENCE_FACTOR;
    }

    // TODO: is it the right place for this method?
    public Level levelFor(int experiencePoints) {
        int levelValue = (int) Math.floor((1 + Math.sqrt(1 + 8 * experiencePoints / EXPERIENCE_FACTOR)) / 2);
        return new Level(levelValue);
    }
}