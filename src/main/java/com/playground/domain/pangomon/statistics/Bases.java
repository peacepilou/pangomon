package com.playground.domain.pangomon.statistics;

import static com.playground.utils.Preconditions.require;

public record Bases(
        int hp,
        int attack,
        int defense,
        int specialAttack,
        int specialDefense,
        int speed
) {
    public Bases {
        require(hp >= 1 && hp <= 255, "Base HP must be between 1 and 255");
        require(attack >= 1 && attack <= 255, "Base Attack must be between 1 and 255");
        require(defense >= 1 && defense <= 255, "Base Defense must be between 1 and 255");
        require(specialAttack >= 1 && specialAttack <= 255, "Base Special Attack must be between 1 and 255");
        require(specialDefense >= 1 && specialDefense <= 255, "Base Special Defense must be between 1 and 255");
        require(speed >= 1 && speed <= 255, "Base Speed must be between 1 and 255");
    }
}
