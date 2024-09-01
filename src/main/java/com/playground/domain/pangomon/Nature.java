package com.playground.domain.pangomon;

import static com.playground.domain.pangomon.Statistic.*;

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

    // TODO: rules to implement
    // bonus = +10%
    // malus = -10%
    private final Statistic bonus;
    private final Statistic malus;

    Nature(Statistic bonus, Statistic malus) {
        this.bonus = bonus;
        this.malus = malus;
    }
}