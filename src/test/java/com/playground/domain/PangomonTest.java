package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import org.junit.jupiter.api.Test;

import static com.playground.domain.PangomonScenari.*;
import static org.junit.jupiter.api.Assertions.*;

class PangomonTest {

    @Test
    void shouldCreatePangomon() {
        // given
        Pangomon expectedBenoit = new Pangomon("Benoit", new Level(1), "fire", 20, 10, 10, 10, 100, 10, 0);
        // when
        Pangomon actualBenoit = Pangomon.create("Benoit", "fire");
        // then
        assertEquals(expectedBenoit, actualBenoit);
    }

    @Test
    void shouldBeKO_whenPvEqual0() {
        // given
        Pangomon actualBenoit = Pangomon.create("Benoit", "fire");
        // when
        Pangomon koPangomon = actualBenoit.takeDamages(20);
        // then
        assertEquals(0, koPangomon.pv());
        assertTrue(koPangomon.isKo());
    }

    @Test
    void shouldBeKO_whenPvIsLessOrEqual0() {
        // given
        Pangomon actualBenoit = Pangomon.create("Benoit", "fire");
        // when
        Pangomon koPangomon = actualBenoit.takeDamages(25);
        // then
        assertEquals(0, koPangomon.pv());
        assertTrue(koPangomon.isKo());
    }

    @Test
    void shouldGainXp() {
        // given
        Pangomon actualBenoit = Pangomon.create("Benoit", "fire");
        // when
        Pangomon pangomon = actualBenoit.modifyXp(100);
        // then
        assertEquals(100, pangomon.xp());
    }

    @Test
    void shouldLooseXp() {
        // given
        Pangomon actualBenoit = Pangomon.create("Benoit", "fire");
        // when
        Pangomon pangomon = actualBenoit.modifyXp(-100);
        // then
        assertEquals(-100, pangomon.xp());
    }

    @Test
    void shouldPassFromLvl1ToLvl2_whenGain100Xp() {
        // given
        Pangomon actualBenoit = Pangomon.create("Benoit", "fire");
        // when
        Pangomon pangomon = actualBenoit.modifyXp(100);
        // then
        assertEquals(2, pangomon.level().value());
    }

    @Test
    void shouldPassFromLvl2ToLvl3_whenGain200Xp() {
        // given
        Pangomon actualBenoitLvl2 = aLeveledPangomon(2);
        // when
        Pangomon pangomon = actualBenoitLvl2.modifyXp(200);
        // then
        assertEquals(3, pangomon.level().value());
    }

    @Test
    void shouldPassFromLvl1To3_whenGain300Xp() {
        // given
        Pangomon actualPango = Pangomon.create("toto", "water");
        // when
        Pangomon pangoWithXp = actualPango.modifyXp(300);
        // then
        assertEquals(3, pangoWithXp.level().value());
    }




}