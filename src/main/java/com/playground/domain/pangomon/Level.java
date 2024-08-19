package com.playground.domain.pangomon;

import java.util.Objects;

public class Level {
    private int value;

    // invariant
    public Level(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Level value can't be less than 1");
        }
        this.value = value;
    }


    public Level gainXp(int xp) {
        int neededXpToLvlUp = value * 100;
        int remainingXp = xp;

        while (remainingXp >= neededXpToLvlUp) {
            value++;
            remainingXp -= neededXpToLvlUp;
            neededXpToLvlUp = value * 100;
        }

        return new Level(value);
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Level level = (Level) o;
        return value == level.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Level{" +
                "value=" + value +
                '}';
    }
}