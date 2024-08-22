package com.playground.domain.pangomon;

public record Progression(
        Level level,
        int experience
) {

    public Progression gainXp(int xp) {
        Level actualLevel = level;
        int remainingXp = xp;

        while (remainingXp >= actualLevel.neededXpToLevel()) {
            actualLevel = actualLevel.levelUp();
            remainingXp -= level.neededXpToLevel();
        }

        return new Progression(
                actualLevel,
                experience + xp
        );
    }
}
