package com.playground.domain.pangomon;

import com.playground.utils.Preconditions;

public record Level(int value) {
    public Level {
        Preconditions.require(value >= 1, "Level value can't be less than 1");
    }

    public int neededXpToLevel() {
        return this.value * 100;
    }

    public Level levelUp() {
        return new Level(this.value + 1);
    }
}