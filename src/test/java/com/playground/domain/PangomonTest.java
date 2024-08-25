package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.playground.domain.PangomonScenari.aLeveledPangomon;
import static org.assertj.core.api.Assertions.assertThat;

class PangomonTest {

    @Test
    void shouldCreatePangomon() {
        // given
        Pangomon actualBenoit = new Pangomon(UUID.randomUUID(), "Benoit", "fire", startingProgression(), 20, 10, 10, 10, 100, 10);
        // when
        Pangomon expectedBenoit = Pangomon.create("Benoit", "fire");
        // then
        assertThat(actualBenoit)
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(UUID.class)
                .isEqualTo(expectedBenoit);
    }

    @Test
    void shouldBeKO_whenPvEqual0() {
        // given
        // when
        Pangomon koPangomon = Pangomon.create("Benoit", "fire").takeDamages(20);

        // then
        assertThat(koPangomon.pv()).isEqualTo(0);
        assertThat(koPangomon.isKo()).isTrue();
    }

    @Test
    void shouldBeKO_whenPvIsLessOrEqual0() {
        // given
        // when
        Pangomon koPangomon = Pangomon.create("Benoit", "fire").takeDamages(25);

        // then
        assertThat(koPangomon.pv()).isEqualTo(0);
        assertThat(koPangomon.isKo()).isTrue();
    }

    @Test
    void shouldGainXp() {
        // given
        // when
        Pangomon pangomon = Pangomon.create("Benoit", "fire").modifyXp(100);

        // then
        assertThat(pangomon.progression().experience()).isEqualTo(100);
    }

    // TODO: Don't do it !
//    @Test
//    void shouldLooseXp() {
//        // given
//        Pangomon actualBenoit = Pangomon.create("Benoit", "fire");
//        // when
//        Pangomon pangomon = actualBenoit.modifyXp(-100);
//        // then
//        assertThat(-100, pangomon.progression().experience());
//    }

    @Test
    void shouldPassFromLvl1ToLvl2_whenGain100Xp() {
        // given
        // when
        Pangomon pangomon = Pangomon.create("Benoit", "fire").modifyXp(100);

        // then
        assertThat(pangomon.progression().experience()).isEqualTo(100);
        assertThat(pangomon.progression().level().value()).isEqualTo(2);
    }

    @Test
    void shouldPassFromLvl2ToLvl3_whenGain200Xp() {
        // given
        // when
        Pangomon pangomon = aLeveledPangomon(2).modifyXp(200);

        // then
        assertThat(pangomon.progression().experience()).isEqualTo(300);
        assertThat(pangomon.progression().level().value()).isEqualTo(3);
    }

    @Test
    void shouldPassFromLvl1To3_whenGain300Xp() {
        // given
        // when
        Pangomon pangoWithXp = Pangomon.create("toto", "water").modifyXp(300);

        // then
        assertThat(pangoWithXp.progression().experience()).isEqualTo(300);
        assertThat(pangoWithXp.progression().level().value()).isEqualTo(3);
    }

    @Test
    void shouldPassFromLvl1To3_whenGain30000Xp() {
        // given
        // when
        Pangomon pangoWithXp = Pangomon.create("toto", "water").modifyXp(30000);

        // then
        assertThat(pangoWithXp.progression().experience()).isEqualTo(30000);
        assertThat(pangoWithXp.progression().level().value()).isEqualTo(151);
    }

    private Progression startingProgression() {
        return new Progression(new Level(1), 0);
    }
}