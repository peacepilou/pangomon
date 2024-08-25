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

        return new Progression(actualLevel, experience + xp);
    }

//    public Progression gainXp(int xp) {
//        int reduce = IntStream.iterate(
//                        this.level.value(),
//                        i -> i < this.level.value() + xp / 100,
//                        i -> i + 1
//                )
//                .reduce(this.experience, (acc, i) -> acc + i * 100);
//
//        return new Progression(this.level, reduce);
//    }
}
