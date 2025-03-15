package com.playground.domain.pangomon;

import com.playground.domain.pangomon.statistics.Bases;
import com.playground.domain.pangomon.statistics.EffortValues;
import com.playground.domain.pangomon.statistics.IndividualValues;

import java.util.UUID;

public class PangomonFactory {
    public static Pangomon createPangomon(UUID id, String name, String type, Progression progression, Bases bases, IndividualValues iv, EffortValues ev, Nature nature) {
        return new Pangomon(
                id,
                name,
                type,
                progression,
                bases,
                iv,
                ev,
                nature
        );
    }
}
