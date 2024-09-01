package com.playground.domain;

import com.playground.domain.pangomon.Pangomon;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.playground.domain.PangomonScenari.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PangomonTest {
    @Nested
    class handleDamages {

        @Test
        void pangomonAttacksAnotherPangomon() {
            Pangomon playerPangomon = aBasicPangomon();
            Pangomon iAPangomon = aBasicPangomon();

            Pangomon iaPangomonHurted = playerPangomon.attacks(iAPangomon);
            assertEquals(5, iaPangomonHurted.pv());
        }

        @Test
        void pangomonTakeDamages() {
            // given
            // when
            Pangomon iAPangomon = aBasicPangomon().takeDamages(5);
            // then
            assertEquals(5, iAPangomon.pv());

        }

        @Test
        void shouldBeKO_whenPvEqual0() {
            // given
            // when
            Pangomon koPangomon = aBasicPangomon().takeDamages(10);

            // then
            assertThat(koPangomon.pv()).isEqualTo(0);
            assertThat(koPangomon.isKo()).isTrue();
        }

        @Test
        void shouldBeKO_whenPvIsLessOrEqual0() {
            // given
            // when
            Pangomon koPangomon = aBasicPangomon().takeDamages(11);

            // then
            assertThat(koPangomon.pv()).isEqualTo(0);
            assertThat(koPangomon.isKo()).isTrue();
        }
    }

    @Nested
    class ExperienceTest {
        @Test
        void shouldGainXp() {
            // given
            // when
            Pangomon pangomon = aBasicPangomon().modifyXp(50);

            // then
            assertThat(pangomon.progression().experience()).isEqualTo(50);
        }

        @Test
        void shouldPassFromLvl1ToLvl2_whenGain100Xp() {
            // given
            // when
            Pangomon pangomon = aBasicPangomon().modifyXp(100);

            // then
            assertThat(pangomon.progression().experience()).isEqualTo(100);
            assertThat(pangomon.progression().level().value()).isEqualTo(2);
        }

        @Test
        void shouldPassFromLvl2ToLvl3_whenGain200Xp() {
            // given
            // when
            Pangomon pangomon = aPangomon().withLevel(2).modifyXp(200);

            // then
            assertThat(pangomon.progression().experience()).isEqualTo(300);
            assertThat(pangomon.progression().level().value()).isEqualTo(3);
        }

        @Test
        void shouldPassFromLvl1To3_whenGain300Xp() {
            // given
            // when
            Pangomon pangoWithXp = aBasicPangomon().modifyXp(300);

            // then
            assertThat(pangoWithXp.progression().experience()).isEqualTo(300);
            assertThat(pangoWithXp.progression().level().value()).isEqualTo(3);
        }

        @Test
        void shouldPassFromLvl1To25_whenGain30000Xp() {
            // given
            // when
            Pangomon pangoWithXp = aBasicPangomon().modifyXp(30000);

            // then
            assertThat(pangoWithXp.progression().experience()).isEqualTo(30000);
            assertThat(pangoWithXp.progression().level().value()).isEqualTo(25);
        }

        @Test
        void shouldPassFromLvl1To25_whenGain32499Xp() {
            // given
            // when
            Pangomon pangoWithXp = aBasicPangomon().modifyXp(32499);

            // then
            assertThat(pangoWithXp.progression().experience()).isEqualTo(32499);
            assertThat(pangoWithXp.progression().level().value()).isEqualTo(25);
        }

        @Test
        void shouldPassFromLvl1To26_whenGain32500Xp() {
            // given
            // when
            Pangomon pangoWithXp = aBasicPangomon().modifyXp(32500);

            // then
            assertThat(pangoWithXp.progression().experience()).isEqualTo(32500);
            assertThat(pangoWithXp.progression().level().value()).isEqualTo(26);
        }

    }
}