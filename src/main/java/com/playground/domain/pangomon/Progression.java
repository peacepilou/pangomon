package com.playground.domain.pangomon;

import java.util.Objects;

public class Progression {

    private Level level;
    private int experience;

    public Progression(Level level, int experience) {
        this.level = level;
        this.experience = experience;
    }

    // TODO : refacto this > use needXpToLvlUp In Level class (final field)
    public Progression gainXp(int xp) {
        int neededXpToLvlUp = level.value() * 100;
        int remainingXp = xp;

        while (remainingXp >= neededXpToLvlUp) {
            this.level.setValue(this.level().value() + 1);
            remainingXp -= neededXpToLvlUp;
            neededXpToLvlUp = this.level.value() * 100;
        }

        return new Progression(
                new Level(this.level.value()),
                experience + xp
        );

    }


    public Level level() {
        return level;
    }

    public int experience() {
        return experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Progression that = (Progression) o;
        return experience == that.experience && Objects.equals(level, that.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level, experience);
    }

    @Override
    public String toString() {
        return "Progression{" +
                "level=" + level +
                ", experience=" + experience +
                '}';
    }
}
