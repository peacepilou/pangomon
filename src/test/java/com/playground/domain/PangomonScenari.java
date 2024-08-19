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
}
