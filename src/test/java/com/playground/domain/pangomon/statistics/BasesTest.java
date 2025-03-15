package com.playground.domain.pangomon.statistics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BasesTest {
    @Test
    void testBaseValuesInvariants() {
        assertThrows(IllegalArgumentException.class, () -> new Bases(0, 1, 1, 1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 0, 1, 1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 1, 0, 1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 1, 1, 0, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 1, 1, 1, 0, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 1, 1, 1, 1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Bases(256, 1, 1, 1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 256, 1, 1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 1, 256, 1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 1, 1, 256, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 1, 1, 1, 256, 1));
        assertThrows(IllegalArgumentException.class, () -> new Bases(1, 1, 1, 1, 1, 256));
    }
}