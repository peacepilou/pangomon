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

        HealthPoints healthPoints = pangomon.getHealthPoints();

        while (experience >= actualLevel.experienceForNextLevel()) {
            experience -= actualLevel.experienceForNextLevel();
            actualLevel = actualLevel.levelUp();
            healthPoints = new HealthPoints(
                    healthPoints.max(),
                    healthPoints.current()
            );
        }

        return new Pangomon(
                pangomon.getId(),
                pangomon.getName(),
                pangomon.getType(),
                new Progression(actualLevel, this.experience + xp),
                pangomon.getBases(),
                pangomon.getIndividualValues(),
                pangomon.getEffortValues(),
                pangomon.getNature()
        );
    }
}
