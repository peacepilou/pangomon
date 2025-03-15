package com.playground.domain.pangomon.statistics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class IndividualValuesTest {
    @Test
    void testIndividualValuesInvariants() {
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(-1, 0, 0, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, -1, 0, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 0, -1, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 0, 0, -1, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 0, 0, 0, -1, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 0, 0, 0, 0, -1));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(32, 0, 0, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 32, 0, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 0, 32, 0, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 0, 0, 32, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 0, 0, 0, 32, 0));
        assertThrows(IllegalArgumentException.class, () -> new IndividualValues(0, 0, 0, 0, 0, 32));
    }
}