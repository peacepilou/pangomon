package com.playground.domain.pangomon;

import com.playground.domain.pangomon.statistics.HealthPoints;

public record Progression(
        Level level,
        int experience
) {
    // TODO: maybe make this recursive ?
    public Pangomon gainExperience(Pangomon pangomon, int xp) {
        int experience = xp;
        Level actualLevel = level;

        HealthPoints healthPoints = pangomon.healthPoints();

        while (experience >= actualLevel.experienceForNextLevel()) {
            experience -= actualLevel.experienceForNextLevel();
            actualLevel = actualLevel.levelUp();
            healthPoints = new HealthPoints(
                    actualLevel,
                    healthPoints.base(),
                    healthPoints.individualValue(),
                    healthPoints.effortValue(),
                    healthPoints.current()
            );
        }

        return new Pangomon(
                pangomon.id(),
                pangomon.name(),
                pangomon.type(),
                new Progression(actualLevel, this.experience + xp),
                healthPoints,
                pangomon.attack(),
                pangomon.defense(),
                pangomon.speed()
        );
    }
}
