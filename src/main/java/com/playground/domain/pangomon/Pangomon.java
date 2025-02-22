package com.playground.domain.pangomon;

import com.playground.domain.pangomon.statistics.HealthPoints;

import java.util.UUID;

public record Pangomon(
        UUID id,
        String name,
        String type,
        Progression progression,
        HealthPoints healthPoints,
        int attack,
        int defense,
        int speed
) {
    public Pangomon takeDamages(int damages) {
        return new Pangomon(
                id,
                name,
                type,
                progression,
                healthPoints.take(damages),
                attack,
                defense,
                speed
        );
    }

    public Pangomon attacks(Pangomon defender) {
        return defender.takeDamages(attack);
    }

    public boolean isKo() {
        return healthPoints.current() <= 0;
    }

    public Pangomon gainExperience(int xp) {
        return progression.gainExperience(this, xp);
    }
}
