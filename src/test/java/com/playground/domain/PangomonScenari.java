package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;
import com.playground.domain.pangomon.statistics.HealthPoints;

import java.util.UUID;

public record PangomonScenari(
        UUID id,
        String name,
        String type,
        Progression progression,
        HealthPoints healthPoints,
        int attack,
        int defense,
        int speed
) {
    public PangomonScenari() {
        Progression progression = new Progression(new Level(1), 0);
        HealthPoints healthPoints = new HealthPoints(progression.level(), 1, 0, 0, 0);

        this(
                UUID.randomUUID(),
                "DefaultName",
                "Normal",
                progression,
                healthPoints,
                5,
                5,
                5
        );
    }

    public static PangomonScenari aPangomon() {
        return new PangomonScenari();
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
        return new PangomonScenari(id, name, type, progression, new HealthPoints(healthPoints.level(), healthPoints.base(), healthPoints.individualValue(), healthPoints.effortValue(), hp), attack, defense, speed);
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
        return new Pangomon(id, name, type, progression, healthPoints, attack, defense, speed);
    }

    private static int experienceFor(int level) {
        return (level - 1) * level / 2 * 100;
    }
}
