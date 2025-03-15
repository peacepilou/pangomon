package com.playground.domain.pangomon.statistics;

import static com.playground.utils.Preconditions.require;

public record EffortValues(
        int hp,
        int attack,
        int defense,
        int specialAttack,
        int specialDefense,
        int speed
) {
    public EffortValues {
        require(hp >= 0 && hp <= 252, "EV HP must be between 0 and 252");
        require(attack >= 0 && attack <= 252, "EV Attack must be between 0 and 252");
        require(defense >= 0 && defense <= 252, "EV Defense must be between 0 and 252");
        require(specialAttack >= 0 && specialAttack <= 252, "EV Special");
        require(specialDefense >= 0 && specialDefense <= 252, "EV Special Defense must be between 0 and 252");
        require(speed >= 0 && speed <= 252, "EV Speed must be between 0 and 252");

        require(hp + attack + defense + specialAttack + specialDefense + speed <= 510, "Total EV must be between 0 and 510");
    }
}
