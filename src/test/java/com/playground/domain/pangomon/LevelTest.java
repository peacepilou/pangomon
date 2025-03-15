package com.playground.domain.pangomon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LevelTest {
    @Test
    void testLevelInvariants() {
        assertThrows(IllegalArgumentException.class, () -> new Level(0));
        assertThrows(IllegalArgumentException.class, () -> new Level(101));
    }
}