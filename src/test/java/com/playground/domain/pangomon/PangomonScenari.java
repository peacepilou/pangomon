package com.playground.domain.pangomon;

import com.playground.domain.pangomon.statistics.Bases;
import com.playground.domain.pangomon.statistics.EffortValues;
import com.playground.domain.pangomon.statistics.HealthPoints;
import com.playground.domain.pangomon.statistics.IndividualValues;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.UUID;

import static com.playground.domain.pangomon.Nature.BASHFUL;

@EqualsAndHashCode
@ToString
public final class PangomonScenari {
    private UUID id;
    private String name;
    private String type;
    private Progression progression;
    private HealthPoints healthPoints;
    private int attack;
    private int defense;
    private int speed;

    public PangomonScenari(
            UUID id,
            String name,
            String type,
            Progression progression,
            HealthPoints healthPoints,
            int attack,
            int defense,
            int speed
    ) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.progression = progression;
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public PangomonScenari() {
        Progression progression = new Progression(new Level(1), 0);
        HealthPoints healthPoints = new HealthPoints(1, 1);
    }

    public static PangomonScenari aPangomon() {
        return new PangomonScenari();
    }

    private static int experienceFor(int level) {
        return (level - 1) * level / 2 * 100;
    }

    public PangomonScenari withId(UUID id) {
        return new PangomonScenari(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withName(String name) {
        return new PangomonScenari(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withType(String type) {
        return new PangomonScenari(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withProgression(Progression progression) {
        return new PangomonScenari(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withExperience(int experience) {
        return new PangomonScenari(id, name, type, new Progression(progression.level(), experience), healthPoints, attack, defense, speed);
    }

    public PangomonScenari withHealthPoints(HealthPoints healthPoints) {
        return new PangomonScenari(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withCurrentHP(int hp) {
        return new PangomonScenari(id, name, type, progression, new HealthPoints(healthPoints.max(), hp), attack, defense, speed);
    }

    public PangomonScenari withAttack(int attack) {
        return new PangomonScenari(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withDefense(int defense) {
        return new PangomonScenari(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withSpeed(int speed) {
        return new PangomonScenari(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withLevel(int level) {
        return new PangomonScenari(id, name, type, new Progression(new Level(level), experienceFor(level)), healthPoints, attack, defense, speed);
    }

    public Pangomon build() {
        return PangomonFactory.createPangomon(id,
                name,
                type,
                progression,
                new Bases(0, 0, 0, 0, 0, 0),
                new IndividualValues(0, 0, 0, 0, 0, 0),
                new EffortValues(0, 0, 0, 0, 0, 0),
                BASHFUL
        );
    }

    public UUID id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String type() {
        return type;
    }

    public Progression progression() {
        return progression;
    }

    public HealthPoints healthPoints() {
        return healthPoints;
    }

    public int attack() {
        return attack;
    }

    public int defense() {
        return defense;
    }

    public int speed() {
        return speed;
    }
}
