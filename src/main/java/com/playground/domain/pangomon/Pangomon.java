package com.playground.domain.pangomon;

import com.playground.domain.pangomon.statistics.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

import static com.playground.domain.pangomon.statistics.Statistic.SPEED;

@ToString
@EqualsAndHashCode
@Getter
public final class Pangomon {
    private final UUID id;
    private final String name;
    private final String type;
    private final Bases bases;
    private final IndividualValues individualValues;
    private final EffortValues effortValues;
    private final Nature nature;
    private final Progression progression;
    private final HealthPoints healthPoints;
    private final Speed speed;

    public Pangomon(UUID id, String name, String type, Progression progression, Bases bases, IndividualValues individualValues, EffortValues effortValues, Nature nature) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.progression = progression;
        this.bases = bases;
        this.individualValues = individualValues;
        this.effortValues = effortValues;
        this.nature = nature;
        this.healthPoints = initializeHP();
        this.speed = initializeSpeed();
    }

    private HealthPoints initializeHP() {
        int basePart = bases.hp() * 2;
        int ivPart = individualValues.hp();
        int evPart = effortValues.hp() / 4;
        int levelPart = progression.level().value();

        int ivAndEvBonuses = ivPart + evPart;
        int maxHp = (((basePart + ivPart + evPart) * levelPart) / 100) + levelPart + 10 + ivAndEvBonuses;

        return new HealthPoints(maxHp);
    }

    private Speed initializeSpeed() {
        int speed = compute(
                SPEED,
                bases.speed(),
                individualValues.speed(),
                effortValues.speed(),
                progression.level().value()
        );

        return new Speed(speed);
    }

    private int compute(Statistic statistic, int base, int iv, int ev, int level) {
        int basePart = base * 2;
        int evPart = ev / 4;
        int computedBase = (((basePart + iv + evPart) * level) / 100) + 5;

        int ivAndEvBonuses = iv + evPart;
        double natureModifier = nature.multiplier(statistic);

        return (int) Math.ceil((computedBase + ivAndEvBonuses) * natureModifier);
    }
}
