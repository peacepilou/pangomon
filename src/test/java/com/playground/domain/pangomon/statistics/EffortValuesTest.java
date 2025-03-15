package com.playground.domain.pangomon.statistics;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EffortValuesTest {
    @Test
    void testEffortValuesInvariants() {
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(-1, 0, 0, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, -1, 0, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 0, -1, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 0, 0, -1, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 0, 0, 0, -1, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 0, 0, 0, 0, -1));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(253, 0, 0, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 253, 0, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 0, 253, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 0, 0, 253, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 0, 0, 0, 253, 0));
        assertThrows(IllegalArgumentException.class, () -> new EffortValues(0, 0, 0, 0, 0, 253));

        assertThrows(IllegalArgumentException.class, () -> new EffortValues(86, 85, 85, 85, 85, 85));
    }
}