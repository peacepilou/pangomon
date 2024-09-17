package com.playground.domain.pangomon;

public record Progression(
        Level level,
        int experience
) {
    public Pangomon gainExperience(Pangomon pangomon, int xp) {
        int experience = xp;
        Level actualLevel = level;

        HealthPoint healthPoints = pangomon.healthPoints();

        while (experience >= actualLevel.experienceForNextLevel()) {
            experience -= actualLevel.experienceForNextLevel();
            actualLevel = actualLevel.levelUp();
            healthPoints = healthPoints.increase();
        }

        return new Pangomon(
                pangomon.id(),
                pangomon.name(),
                pangomon.type(),
                new Progression(actualLevel, this.experience + xp),
                pangomon.pv(),
                healthPoints,
                pangomon.attack(),
                pangomon.defense(),
                pangomon.speed()
        );
    }
}
