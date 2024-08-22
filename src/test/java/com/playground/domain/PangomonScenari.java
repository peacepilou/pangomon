package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;

public class PangomonScenari {

    public static Pangomon aLeveledPangomon(int lvl) {
        return new Pangomon(
                "",
                "",
                new Progression(new Level(lvl), lvl * 100),
                0,
                0,
                0,
                0,
                0,
                0
        );
    }

    public static Pangomon withSpeed(int speed) {
        return new Pangomon(
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
}
