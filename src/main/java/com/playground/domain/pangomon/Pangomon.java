package com.playground.domain.pangomon;

import java.util.UUID;

public record Pangomon(
        UUID id,
        String name,
        String type,
        Progression progression,
        int pv,
        HealthPoint healthPoints,
        int attack,
        int defense,
        int speed
) {
    public Pangomon takeDamages(int damages) {
        int remainingPv = Math.max(this.pv - damages, 0);

        return new Pangomon(
                this.id,
                this.name,
                this.type,
                this.progression,
                remainingPv,
                this.healthPoints,
                this.attack,
                this.defense,
                this.speed
        );
    }

    public Pangomon attacks(Pangomon defender) {
        return defender.takeDamages(this.attack);
    }

    public boolean isKo() {
        return this.pv <= 0;
    }

    public Pangomon modifyXp(int xp) {
        return this.progression.gainExperience(this, xp);
    }

}
