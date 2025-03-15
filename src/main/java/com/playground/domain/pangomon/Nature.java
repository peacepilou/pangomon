package com.playground.domain.pangomon;

import com.playground.domain.pangomon.statistics.Statistic;

import java.util.Map;

import static com.playground.domain.pangomon.statistics.Statistic.*;

public enum Nature {
    ADAMANT(ATTACK, SPECIAL_ATTACK),
    BASHFUL(NONE, NONE),
    BOLD(DEFENSE, ATTACK),
    BRAVE(ATTACK, SPEED),
    CALM(SPECIAL_DEFENSE, ATTACK),
    CAREFUL(SPECIAL_DEFENSE, SPECIAL_ATTACK),
    DOCILE(NONE, NONE),
    GENTLE(SPECIAL_DEFENSE, DEFENSE),
    HARDY(NONE, NONE),
    HASTY(SPEED, DEFENSE),
    IMPISH(DEFENSE, SPECIAL_ATTACK),
    JOLLY(SPEED, SPECIAL_ATTACK),
    LAX(DEFENSE, SPECIAL_DEFENSE),
    LONELY(ATTACK, DEFENSE),
    MILD(SPECIAL_ATTACK, DEFENSE),
    MODEST(SPECIAL_ATTACK, ATTACK),
    NAIVE(SPEED, SPECIAL_DEFENSE),
    NAUGHTY(ATTACK, SPECIAL_DEFENSE),
    QUIET(SPECIAL_ATTACK, SPEED),
    QUIRKY(NONE, NONE),
    RASH(SPECIAL_ATTACK, SPECIAL_DEFENSE),
    RELAXED(DEFENSE, SPEED),
    SASSY(SPECIAL_DEFENSE, SPEED),
    SERIOUS(NONE, NONE),
    TIMID(SPEED, ATTACK);

    public static final double BONUS = 1.1;
    public static final double MALUS = 0.9;
    private final Statistic statisticToIncrease;
    private final Statistic statisticToDecrease;

    Nature(Statistic statisticToIncrease, Statistic statisticToDecrease) {
        this.statisticToIncrease = statisticToIncrease;
        this.statisticToDecrease = statisticToDecrease;
    }

    public double multiplier(Statistic statistic) {
        return modifiers().containsKey(statistic) ? modifiers().get(statistic) : 1;
    }

    private Map<Statistic, Double> modifiers() {
        if (statisticToIncrease == NONE && statisticToDecrease == NONE) {
            return Map.of();
        }

        return Map.of(statisticToIncrease, BONUS, statisticToDecrease, MALUS);
    }
}
