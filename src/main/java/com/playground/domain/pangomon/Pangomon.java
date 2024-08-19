package com.playground.domain.pangomon;

public record Pangomon (
        String name,
        Level level,
        String type,
        int pv,
        int attack,
        int defense,
        int speed,
        int accuracy,
        int dodge,
        int xp
) {

    public static Pangomon create(String name, String type) {
        return new Pangomon(
                name,
                new Level(1),
                type,
                20,
                10,
                10,
                10,
                100,
                10,
                0
                );
    }

    public Pangomon takeDamages(int damages) {
        int remainingPv = Math.max(this.pv - damages, 0);

        return new Pangomon(
                this.name,
                this.level,
                this.type,
                remainingPv,
                this.attack,
                this.defense,
                this.speed,
                this.accuracy,
                this.dodge,
                this.xp
        );
    }

    public boolean isKo() {
        return this.pv <= 0;
    }

    public Pangomon modifyXp(int xp) {
        int xpResult = this.xp + xp;
        return new Pangomon(
                this.name,
                this.level.gainXp(xp),
                this.type,
                this.pv,
                this.attack,
                this.defense,
                this.speed,
                this.accuracy,
                this.dodge,
                xpResult
        );
    }

}
