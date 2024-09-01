package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;

import java.util.UUID;

public class PangomonScenari {

    public static Pangomon aLeveledPangomon(int lvl) {
        return new Pangomon(
                UUID.randomUUID(),
                "",
                "",
                new Progression(new Level(lvl), experienceFor(lvl)),
                0,
                0,
                0,
                0,
                0,
                0
        );
    }

    public static Pangomon withBaseStats() {
        return new Pangomon(
                UUID.randomUUID(),
                "Base",
                "Base",
                new Progression(new Level(1), 0),
                10,
                10,
                10,
                10,
                10,
                10
        );
    }

    public static Pangomon withSpeed(int speed) {
        return new Pangomon(
                UUID.randomUUID(),
                "Base",
                "Base",
                new Progression(new Level(1), 0),
                10,
                10,
                10,
                speed,
                10,
                10
        );
    }



    private static int experienceFor(int level) {
        return (level - 1) * level / 2 * 100;
    }
}
