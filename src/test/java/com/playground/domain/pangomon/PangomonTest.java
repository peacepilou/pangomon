package com.playground.domain.pangomon;

import com.playground.domain.pangomon.statistics.Bases;
import com.playground.domain.pangomon.statistics.EffortValues;
import com.playground.domain.pangomon.statistics.IndividualValues;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.playground.domain.pangomon.Nature.*;
import static org.assertj.core.api.Assertions.assertThat;

class PangomonTest {
    @Nested
    class PangomonStatistics {
        Progression progression = new Progression(new Level(1), 0);

        @Nested
        class HP_level_1 {
            @Test
            void min_hp_should_be_11() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(1, 1, 1, 1, 1, 1),
                        new IndividualValues(0, 1, 1, 1, 1, 1),
                        new EffortValues(0, 1, 1, 1, 1, 1),
                        BASHFUL
                );

                assertThat(pangomon.getHealthPoints().max()).isEqualTo(11);
            }

            @Test
            void hp_with_max_BASE_should_be_16() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(255, 1, 1, 1, 1, 1),
                        new IndividualValues(0, 1, 1, 1, 1, 1),
                        new EffortValues(0, 1, 1, 1, 1, 1),
                        BASHFUL
                );

                assertThat(pangomon.getHealthPoints().max()).isEqualTo(16);
            }

            @Test
            void hp_with_max_IV_should_be_42() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(1, 1, 1, 1, 1, 1),
                        new IndividualValues(31, 1, 1, 1, 1, 1),
                        new EffortValues(0, 1, 1, 1, 1, 1),
                        BASHFUL
                );

                assertThat(pangomon.getHealthPoints().max()).isEqualTo(42);
            }

            @Test
            void hp_with_max_BASE_and_max_IV_should_be_47() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(255, 1, 1, 1, 1, 1),
                        new IndividualValues(31, 1, 1, 1, 1, 1),
                        new EffortValues(0, 1, 1, 1, 1, 1),
                        BASHFUL
                );

                assertThat(pangomon.getHealthPoints().max()).isEqualTo(47);
            }

            @Test
            void hp_with_max_EV_should_be_74() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(1, 1, 1, 1, 1, 1),
                        new IndividualValues(0, 1, 1, 1, 1, 1),
                        new EffortValues(252, 1, 1, 1, 1, 1),
                        BASHFUL
                );

                assertThat(pangomon.getHealthPoints().max()).isEqualTo(74);
            }

            @Test
            void hp_with_max_BASE_and_max_EV_should_be_79() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(255, 1, 1, 1, 1, 1),
                        new IndividualValues(0, 1, 1, 1, 1, 1),
                        new EffortValues(252, 1, 1, 1, 1, 1),
                        BASHFUL
                );

                assertThat(pangomon.getHealthPoints().max()).isEqualTo(79);
            }

            @Test
            void hp_with_max_EV_and_max_IV_should_be_105() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(1, 1, 1, 1, 1, 1),
                        new IndividualValues(31, 1, 1, 1, 1, 1),
                        new EffortValues(252, 1, 1, 1, 1, 1),
                        BASHFUL
                );

                assertThat(pangomon.getHealthPoints().max()).isEqualTo(105);
            }

            @Test
            void hp_with_max_BASE_and_max_EV_and_max_IV_should_be_111() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(255, 1, 1, 1, 1, 1),
                        new IndividualValues(31, 1, 1, 1, 1, 1),
                        new EffortValues(252, 1, 1, 1, 1, 1),
                        BASHFUL
                );

                assertThat(pangomon.getHealthPoints().max()).isEqualTo(111);
            }
        }

        @Nested
        class SPEED_level_1 {
            @Test
            void min_speed_without_nature_should_be_5() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(1, 1, 1, 1, 1, 1),
                        new IndividualValues(0, 1, 1, 1, 1, 0),
                        new EffortValues(0, 1, 1, 1, 1, 0),
                        BASHFUL
                );

                assertThat(pangomon.getSpeed().value()).isEqualTo(5);
            }

            @Test
            void min_speed_with_nature_should_be_5() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(1, 1, 1, 1, 1, 1),
                        new IndividualValues(0, 1, 1, 1, 1, 0),
                        new EffortValues(0, 1, 1, 1, 1, 0),
                        SASSY
                );

                assertThat(pangomon.getSpeed().value()).isEqualTo(5);
            }

            @Test
            void max_speed_without_nature_should_be_105() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(1, 1, 1, 1, 1, 255),
                        new IndividualValues(0, 1, 1, 1, 1, 31),
                        new EffortValues(0, 1, 1, 1, 1, 252),
                        BASHFUL
                );

                assertThat(pangomon.getSpeed().value()).isEqualTo(105);
            }

            @Test
            void max_speed_with_nature_should_be_116() {
                Pangomon pangomon = new Pangomon(
                        UUID.randomUUID(),
                        "DefaultName",
                        "Normal",
                        progression,
                        new Bases(1, 1, 1, 1, 1, 255),
                        new IndividualValues(0, 1, 1, 1, 1, 31),
                        new EffortValues(0, 1, 1, 1, 1, 252),
                        TIMID
                );

                assertThat(pangomon.getSpeed().value()).isEqualTo(116);
            }
        }
    }

//    @Nested
//    class handleDamages {
//        @Test
//        void pangomonAttacksAnotherPangomon() {
//            Pangomon playerPangomon = aPangomon().withAttack(5).build();
//            Pangomon iAPangomon = aPangomon().withCurrentHP(10).build();
//
//            Pangomon iaPangomonHurted = playerPangomon.attacks(iAPangomon);
//            assertEquals(5, iaPangomonHurted.healthPoints().current());
//        }
//
//        @Test
//        void pangomonTakeDamages() {
//            // given
//            // when
//            Pangomon iAPangomon = aPangomon().withCurrentHP(10).build().takeDamages(5);
//
//            // then
//            assertEquals(5, iAPangomon.healthPoints().current());
//
//        }
//
//        @Test
//        void shouldBeKO_whenPvEqual0() {
//            // given
//            // when
//            Pangomon koPangomon = aPangomon().withCurrentHP(10).build().takeDamages(10);
//
//            // then
//            assertThat(koPangomon.healthPoints().current()).isEqualTo(0);
//            assertThat(koPangomon.isKo()).isTrue();
//        }
//
//        @Test
//        void shouldBeKO_whenPvIsLessOrEqual0() {
//            // given
//            // when
//            Pangomon koPangomon = aPangomon().withCurrentHP(10).build().takeDamages(11);
//
//            // then
//            assertThat(koPangomon.healthPoints().current()).isEqualTo(0);
//            assertThat(koPangomon.isKo()).isTrue();
//        }
//    }
//
//    @Nested
//    class ExperienceTest {
//        @Test
//        void shouldGainXp() {
//            // given
//            // when
//            Pangomon pangomon = aPangomon().withExperience(0).build().gainExperience(50);
//
//            // then
//            assertThat(pangomon.progression().experience()).isEqualTo(50);
//        }
//
//        @Test
//        void shouldPassFromLvl1ToLvl2_whenGain100Xp() {
//            // given
//            // when
//            Pangomon pangomon = aPangomon().withExperience(0).build().gainExperience(100);
//
//            // then
//            assertThat(pangomon.progression().experience()).isEqualTo(100);
//            assertThat(pangomon.progression().level().value()).isEqualTo(2);
//        }
//
//        @Test
//        void shouldPassFromLvl2ToLvl3_whenGain200Xp() {
//            // given
//            // when
//            Pangomon pangomon = aPangomon()
//                    .withLevel(2)
//                    .build()
//                    .gainExperience(200);
//
//            // then
//            assertThat(pangomon.progression().experience()).isEqualTo(300);
//            assertThat(pangomon.progression().level().value()).isEqualTo(3);
//        }
//
//        @Test
//        void shouldPassFromLvl1To3_whenGain300Xp() {
//            // given
//            // when
//            Pangomon pangoWithXp = aPangomon().withExperience(0).build().gainExperience(300);
//
//            // then
//            assertThat(pangoWithXp.progression().experience()).isEqualTo(300);
//            assertThat(pangoWithXp.progression().level().value()).isEqualTo(3);
//        }
//
//        @Test
//        void shouldPassFromLvl1To25_whenGain30000Xp() {
//            // given
//            // when
//            Pangomon pangoWithXp = aPangomon().withExperience(0).build().gainExperience(30000);
//
//            // then
//            assertThat(pangoWithXp.progression().experience()).isEqualTo(30000);
//            assertThat(pangoWithXp.progression().level().value()).isEqualTo(25);
//        }
//
//        @Test
//        void shouldPassFromLvl1To25_whenGain32499Xp() {
//            // given
//            // when
//            Pangomon pangoWithXp = aPangomon().withExperience(0).build().gainExperience(32499);
//
//            // then
//            assertThat(pangoWithXp.progression().experience()).isEqualTo(32499);
//            assertThat(pangoWithXp.progression().level().value()).isEqualTo(25);
//        }
//
//        @Test
//        void shouldPassFromLvl1To26_whenGain32500Xp() {
//            // given
//            // when
//            Pangomon pangoWithXp = aPangomon().withExperience(0).build().gainExperience(32500);
//
//            // then
//            assertThat(pangoWithXp.progression().experience()).isEqualTo(32500);
//            assertThat(pangoWithXp.progression().level().value()).isEqualTo(26);
//        }
//
//    }
//
//    // TODO: make complete stats checks
//    @Nested
//    class LevelUpTest {
//        @Test
//        void pangomonWith1BaseHP_levelUp() {
//            // given
//            HealthPoints healthPoints = new HealthPoints(new Level(1), 1, 0, 0, 0);
//
//            // when
//            Pangomon pangomon = aPangomon()
//                    .withLevel(1)
//                    .withHealthPoints(healthPoints)
//                    .build()
//                    .gainExperience(100);
//
//            // then
//            assertThat(pangomon.healthPoints().current()).isEqualTo(12);
//        }
//
//        @Test
//        void pangomonWith255BaseHPAndLevel1_shouldHave16HPMax() {
//            // given
//            HealthPoints healthPoints = new HealthPoints(new Level(1), 255, 0, 0, 0);
//
//            // when
//            Pangomon pangomon = aPangomon()
//                    .withLevel(1)
//                    .withHealthPoints(healthPoints)
//                    .build()
//                    .gainExperience(100);
//
//            // then
//            assertThat(pangomon.healthPoints().current()).isEqualTo(22);
//        }
//    }
}