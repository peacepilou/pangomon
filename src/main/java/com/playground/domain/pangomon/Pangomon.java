package com.playground.domain.pangomon;

import java.util.UUID;

public record Pangomon(
        UUID id,
        String name,
        String type,
        Progression progression,
        int pv,
        int attack,
        int defense,
        int speed,
        int accuracy,
        int dodge
) {

    public static Pangomon create(String name, String type) {
        return new Pangomon(
                UUID.randomUUID(),
                name,
                type,
                new Progression(new Level(1), 0),
                20,
                10,
                10,
                10,
                100,
                10
        );
    }

    public Pangomon takeDamages(int damages) {
        int remainingPv = Math.max(this.pv - damages, 0);

        return new Pangomon(
                this.id,
                this.name,
                this.type,
                this.progression,
                remainingPv,
                this.attack,
                this.defense,
                this.speed,
                this.accuracy,
                this.dodge
        );
    }

    public Pangomon attacks(Pangomon defender) {
        return defender.takeDamages(this.attack);
    }

    public boolean isKo() {
        return this.pv <= 0;
    }

    public Pangomon modifyXp(int xp) {
        return new Pangomon(
                this.id,
                this.name,
                this.type,
                this.progression.gainXp(xp),
                this.pv,
                this.attack,
                this.defense,
                this.speed,
                this.accuracy,
                this.dodge
        );
    }

}
