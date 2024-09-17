package com.playground.domain;

import com.playground.domain.pangomon.HealthPoint;
import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;

import java.util.UUID;

public record PangomonScenari(
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
    public PangomonScenari() {
        this(
                UUID.randomUUID(),
                "DefaultName",
                "Normal",
                new Progression(new Level(1), 0),
                10,
                new HealthPoint(10, 10),
                5,
                5,
                5
        );
    }

    public static PangomonScenari aPangomon() {
        return new PangomonScenari();
    }

    public static Pangomon aBasicPangomon() {
        return new PangomonScenari().build();
    }

    public PangomonScenari withId(UUID id) {
        return new PangomonScenari(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withName(String name) {
        return new PangomonScenari(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withType(String type) {
        return new PangomonScenari(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withProgression(Progression progression) {
        return new PangomonScenari(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withPv(int pv) {
        return new PangomonScenari(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withHealthPoints(int healthPoints) {
        return new PangomonScenari(id, name, type, progression, pv, new HealthPoint(healthPoints, this.healthPoints.base()), attack, defense, speed);
    }

    public PangomonScenari withBaseHealthPoints(int baseHealthPoints) {
        return new PangomonScenari(id, name, type, progression, pv, new HealthPoint(healthPoints.value(), baseHealthPoints), attack, defense, speed);
    }

    public PangomonScenari withAttack(int attack) {
        return new PangomonScenari(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withDefense(int defense) {
        return new PangomonScenari(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withSpeed(int speed) {
        return new PangomonScenari(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    public PangomonScenari withLevel(int level) {
        return new PangomonScenari(id, name, type, new Progression(new Level(level), experienceFor(level)), pv, healthPoints, attack, defense, speed);
    }

    public Pangomon build() {
        return new Pangomon(id, name, type, progression, pv, healthPoints, attack, defense, speed);
    }

    private static int experienceFor(int level) {
        return (level - 1) * level / 2 * 100;
    }
}
