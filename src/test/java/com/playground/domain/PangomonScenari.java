package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;

public class PangomonScenari {

    public static Pangomon aLeveledPangomon(int lvl) {
        return new Pangomon(
                "",
                new Level(lvl),
                "",
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );
    }
}
