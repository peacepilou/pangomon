package com.playground.domain.pangomon;

// HP Base -> from 10 to 255
public record HealthPoint(
        int value,
        int base
) {
    // each level = +(Base / 50) + (SUM (EV + IV) / 100)
    public HealthPoint increase() {
        return new HealthPoint(
                this.value + (this.base / 50),
                this.base
        );
    }

    // TODO: is it the right place for this method?
    public HealthPoint healthPointsFor(Level level) {
        // Pangomon at specific level = (((2 x Base + IV + (EV/4)) x niveau) / 100) + niveau + 10
        return new HealthPoint(
                (int) Math.floor((((2 * this.base) * level.value()) / 100) + level.value() + 10),
                this.base
        );
    }
}
