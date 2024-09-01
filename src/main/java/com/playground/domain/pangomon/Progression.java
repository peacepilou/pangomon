package com.playground.domain.pangomon;

public record Progression(
        Level level,
        int experience
) {
    private static final double EXPERIENCE_FACTOR = 100.0;

    public Progression gainXp(int xp) {
        int finalExperience = experience + xp;
        return new Progression(
                levelFor(finalExperience),
                finalExperience
        );
    }

    private Level levelFor(int experiencePoints) {
        // TODO : Use methods from Level class
        int levelValue = (int) Math.floor((1 + Math.sqrt(1 + 8 * experiencePoints / EXPERIENCE_FACTOR)) / 2);
        return new Level(levelValue);
    }

}
