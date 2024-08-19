package com.playground.domain.pangomon;

import java.util.Objects;

public class Level {
    private int value;
    private final int needXpToLvlUp;

    // invariant
    public Level(int value) {
        // TODO : is there a better way to handle invariant ? (record ?)
        if (value < 1) {
            throw new IllegalArgumentException("Level value can't be less than 1");
        }
        this.value = value;
        this.needXpToLvlUp = value * 100;
    }

    public int value() {
        return this.value;
    }

    public int needXpToLvlUp() {
        return needXpToLvlUp;
    }

    // TODO : remove this
    public void setValue(int value) {
        this.value = value;
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