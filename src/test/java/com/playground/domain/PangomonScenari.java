package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;

import java.util.UUID;

public class PangomonScenari {
    private final UUID id = UUID.randomUUID();
    private final String name = "DefaultName";
    private final String type = "Normal";
    private final Progression progression = new Progression(new Level(1), 0);
    private final int pv = 10;
    private final int attack = 5;
    private final int defense = 5;
    private final int speed = 5;

    public static PangomonScenari aPangomon() {
        return new PangomonScenari();
    }

    public static Pangomon aBasicPangomon() {
        return new PangomonScenari().build();
    }

    public Pangomon withId(UUID id) {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    public Pangomon withName(String name) {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    public Pangomon withType(String type) {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    public Pangomon withProgression(Progression progression) {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    public Pangomon withPv(int pv) {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    public Pangomon withAttack(int attack) {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    public Pangomon withDefense(int defense) {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    public Pangomon withSpeed(int speed) {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    public Pangomon withLevel(int level) {
        return new Pangomon(id, name, type, new Progression(new Level(level), experienceFor(level)), pv, attack, defense, speed);
    }

    private Pangomon build() {
        return new Pangomon(id, name, type, progression, pv, attack, defense, speed);
    }

    private static int experienceFor(int level) {
        return (level - 1) * level / 2 * 100;
    }
}
