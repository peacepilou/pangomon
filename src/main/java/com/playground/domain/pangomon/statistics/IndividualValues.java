package com.playground.domain.pangomon.statistics;

import static com.playground.utils.Preconditions.require;

public record IndividualValues(
        int hp,
        int attack,
        int defense,
        int specialAttack,
        int specialDefense,
        int speed
) {
    public IndividualValues {
        require(hp >= 0 && hp <= 31, "IV HP must be between 0 and 31");
        require(attack >= 0 && attack <= 31, "IV Attack must be between 0 and 31");
        require(defense >= 0 && defense <= 31, "IV Defense must be between 0 and 31");
        require(specialAttack >= 0 && specialAttack <= 31, "IV Special Attack must be between 0 and 31");
        require(specialDefense >= 0 && specialDefense <= 31, "IV Special Defense must be between 0 and 31");
        require(speed >= 0 && speed <= 31, "IV Speed must be between 0 and 31");
    }
}
