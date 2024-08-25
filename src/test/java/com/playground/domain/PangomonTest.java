package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;
import org.junit.jupiter.api.Nested;
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

    private Progression startingProgression() {
        return new Progression(new Level(1), 0);
    }

    @Nested
    class ExperienceTest {
        @Test
        void shouldGainXp() {
            // given
            // when
            Pangomon pangomon = aLeveledPangomon(1).modifyXp(50);

            // then
            assertThat(pangomon.progression().experience()).isEqualTo(50);
        }

        @Test
        void shouldPassFromLvl1ToLvl2_whenGain100Xp() {
            // given
            // when
            Pangomon pangomon = aLeveledPangomon(1).modifyXp(100);

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
            Pangomon pangoWithXp = aLeveledPangomon(1).modifyXp(300);

            // then
            assertThat(pangoWithXp.progression().experience()).isEqualTo(300);
            assertThat(pangoWithXp.progression().level().value()).isEqualTo(3);
        }

        @Test
        void shouldPassFromLvl1To25_whenGain30000Xp() {
            // given
            // when
            Pangomon pangoWithXp = aLeveledPangomon(1).modifyXp(30000);

            // then
            assertThat(pangoWithXp.progression().experience()).isEqualTo(30000);
            assertThat(pangoWithXp.progression().level().value()).isEqualTo(25);
        }

        @Test
        void shouldPassFromLvl1To25_whenGain32499Xp() {
            // given
            // when
            Pangomon pangoWithXp = aLeveledPangomon(1).modifyXp(32499);

            // then
            assertThat(pangoWithXp.progression().experience()).isEqualTo(32499);
            assertThat(pangoWithXp.progression().level().value()).isEqualTo(25);
        }

        @Test
        void shouldPassFromLvl1To26_whenGain32500Xp() {
            // given
            // when
            Pangomon pangoWithXp = aLeveledPangomon(1).modifyXp(32500);

            // then
            assertThat(pangoWithXp.progression().experience()).isEqualTo(32500);
            assertThat(pangoWithXp.progression().level().value()).isEqualTo(26);
        }

    }
}