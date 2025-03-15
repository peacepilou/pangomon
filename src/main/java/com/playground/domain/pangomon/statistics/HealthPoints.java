package com.playground.domain.pangomon.statistics;

import static com.playground.utils.Preconditions.require;

public record HealthPoints(
        int max,
        int current
) {
    public HealthPoints(int max) {
        this(max, max);
    }

    public HealthPoints {
        require(current >= 0, "Current hp should be positive.");
    }

    public HealthPoints take(int damages) {
        return new HealthPoints(
                max,
                Math.max(current - damages, 0)
        );
    }

    public HealthPoints heal(int heal) {
        return new HealthPoints(
                max,
                Math.min(current + heal, max)
        );
    }
}
