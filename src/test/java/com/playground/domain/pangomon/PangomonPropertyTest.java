package com.playground.domain.pangomon;

import com.playground.domain.pangomon.statistics.Bases;
import com.playground.domain.pangomon.statistics.EffortValues;
import com.playground.domain.pangomon.statistics.IndividualValues;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.UUID;
import java.util.stream.Stream;

import static com.playground.domain.pangomon.Nature.BASHFUL;
import static com.playground.domain.pangomon.Nature.TIMID;
import static org.assertj.core.api.Assertions.assertThat;

class PangomonPropertyTest {

    private static int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    @Nested
    class HealthPoints {
        static Stream<Arguments> generateRandomData() {
            return Stream.generate(() -> Arguments.of(
                    randomInt(1, 255),
                    randomInt(0, 31),
                    randomInt(0, 252),
                    randomInt(1, 100)
            )).limit(1000);
        }

        @ParameterizedTest
        @MethodSource("generateRandomData")
        void HealthPoints_should_be_between_11_and_808(int baseHP, int ivHP, int evHP, int level) {
            Bases bases = new Bases(baseHP, 1, 1, 1, 1, 1);
            IndividualValues iv = new IndividualValues(ivHP, 1, 1, 1, 1, 1);
            EffortValues ev = new EffortValues(evHP, 1, 1, 1, 1, 1);
            Progression progression = new Progression(new Level(level), 0);

            Pangomon pangomon = new Pangomon(
                    UUID.randomUUID(),
                    "TestPangomon",
                    "Normal",
                    progression,
                    bases,
                    iv,
                    ev,
                    BASHFUL
            );

            int computedMaxHP = pangomon.getHealthPoints().max();

            int minExpectedHP = 11;
            int maxExpectedHP = ((((255 * 2) + 31 + (252 / 4)) * 100) / 100) + 100 + 10 + (31 + (252 / 4));

            assertThat(computedMaxHP)
                    .isGreaterThanOrEqualTo(minExpectedHP)
                    .isLessThanOrEqualTo(maxExpectedHP);
        }
    }

    @Nested
    class Speed {
        static Stream<Arguments> generateRandomData() {
            return Stream.generate(() -> Arguments.of(
                    randomInt(1, 255),
                    randomInt(0, 31),
                    randomInt(0, 252),
                    randomInt(1, 100)
            )).limit(1000);
        }

        @ParameterizedTest
        @MethodSource("generateRandomData")
        void Speed_without_nature_should_be_between_5_and_703(int baseSpeed, int ivSpeed, int evSpeed, int level) {
            Bases bases = new Bases(1, 1, 1, 1, 1, baseSpeed);
            IndividualValues iv = new IndividualValues(0, 0, 0, 0, 0, ivSpeed);
            EffortValues ev = new EffortValues(0, 0, 0, 0, 0, evSpeed);
            Progression progression = new Progression(new Level(level), 0);

            Pangomon pangomon = new Pangomon(
                    UUID.randomUUID(),
                    "TestPangomon",
                    "Normal",
                    progression,
                    bases,
                    iv,
                    ev,
                    BASHFUL
            );

            int computedSpeed = pangomon.getSpeed().value();

            int minExpectedSpeed = 5;
            int maxExpectedSpeed = ((((255 * 2) + 31 + (252 / 4)) * 100) / 100) + 5 + (31 + (252 / 4));

            assertThat(computedSpeed)
                    .isGreaterThanOrEqualTo(minExpectedSpeed)
                    .isLessThanOrEqualTo(maxExpectedSpeed);
        }

        @ParameterizedTest
        @MethodSource("generateRandomData")
        void Speed_with_nature_bonus_should_be_between_5_and_708(int baseSpeed, int ivSpeed, int evSpeed, int level) {
            Bases bases = new Bases(1, 1, 1, 1, 1, baseSpeed);
            IndividualValues iv = new IndividualValues(0, 0, 0, 0, 0, ivSpeed);
            EffortValues ev = new EffortValues(0, 0, 0, 0, 0, evSpeed);
            Progression progression = new Progression(new Level(level), 0);

            Pangomon pangomon = new Pangomon(
                    UUID.randomUUID(),
                    "TestPangomon",
                    "Normal",
                    progression,
                    bases,
                    iv,
                    ev,
                    TIMID
            );

            int computedSpeed = pangomon.getSpeed().value();

            int minExpectedSpeed = 5;
            int maxExpectedSpeed = ((((255 * 2) + 31 + (252 / 4)) * 100) / 100) + 5 + (31 + (252 / 4));

            assertThat(computedSpeed)
                    .isGreaterThanOrEqualTo((int) (minExpectedSpeed * Nature.BONUS))
                    .isLessThanOrEqualTo((int) (maxExpectedSpeed * Nature.BONUS));
        }

    }
}
