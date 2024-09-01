package com.playground.domain.pangomon;

public record Progression(
        Level level,
        int experience
) {

//    public Progression gainXp(int xp) {
//        Level actualLevel = level;
//        int remainingXp = xp;
//
//        while (remainingXp >= actualLevel.neededXpToLevel()) {
//            actualLevel = actualLevel.levelUp();
//            remainingXp -= actualLevel.neededXpToLevel();
//        }
//
//        return new Progression(actualLevel, experience + xp);
//    }

    public Progression gainXp(int xp) {
        int finalExperience = experience + xp;
        return new Progression(levelFor(finalExperience), finalExperience);
    }

    private Level levelFor(int experiencePoints) {
        // TODO : Use methods from Level class
        int levelValue = (int) Math.floor((1 + Math.sqrt(1 + 8 * experiencePoints / 100.0)) / 2);
        return new Level(levelValue);
    }

}
