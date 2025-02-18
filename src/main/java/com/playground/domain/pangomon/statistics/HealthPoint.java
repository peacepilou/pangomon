package com.playground.domain.pangomon.statistics;

import com.playground.domain.pangomon.Level;

// HP Base -> from 10 to 255
public class HealthPoint {
        int value;
        private final int base;
        private final int iv;

    public HealthPoint(int value, int base, int iv) {
        this.value = value;
        this.base = base;
        this.iv = iv;
    }

    // each level : value + (Base / 50) + (SUM (EV + IV) / 100)
    public HealthPoint increase() {
        return new HealthPoint(
                this.value + (this.base / 50) + ivValueImpactOnHp(iv),
                this.base,
                this.iv
        );
    }

    // TODO: is it the right place for this method?
    public HealthPoint healthPointsFor(Level level) {
        // Pangomon at specific level = (((2 x Base + IV + (EV/4)) x niveau) / 100) + niveau + 10
        return new HealthPoint(
                (int) Math.floor((((2 * this.base) * level.value()) / 100) + level.value() + 10),
                this.base,
                this.iv
        );
    }

    private int ivValueImpactOnHp(int iv) {
        double ivD = iv;
        return (int) Math.ceil(ivD / 100);
    }

    public int value() {
        return value;
    }

    public int base() {
        return base;
    }

    public int iv() {
        return iv;
    }
}
