package com.playground.domain.pangomon.statistics;

import com.playground.domain.pangomon.Level;
import static com.playground.utils.Preconditions.require;

// TODO: do we need a StatisticsComputer ?
// TODO: do we need to have all Base in the pangomon ? BaseHp, BaseAttack, ...
// TODO: do we need to have all IV in the pangomon ? IVHp, IVAttack, ...
// TODO: do we need to have all EV in the pangomon ? EVHp, EVAttack, ...
public record HealthPoints(
        Level level,
        int base,
        int individualValue,
        int effortValue,
        int current
) {
    public HealthPoints {
        require(base >= 1 && base <= 255, "Base HP must be between 1 and 255");
        require(individualValue >= 0 && individualValue <= 31, "IV must be between 0 and 31");
        require(effortValue >= 0 && effortValue <= 252, "EV must be between 0 and 252");
    }

    public HealthPoints take(int damages) {
        return new HealthPoints(
                level,
                base,
                individualValue,
                effortValue,
                Math.max(current - damages, 0)
        );
    }

    public HealthPoints heal(int heal) {
        return new HealthPoints(
                level,
                base,
                individualValue,
                effortValue,
                Math.min(current + heal, max())
        );
    }

    public int max() {
        return ((((2 * base()) + individualValue() + (effortValue() / 4)) * level().value()) / 100) + level().value() + 10;
    }
}
