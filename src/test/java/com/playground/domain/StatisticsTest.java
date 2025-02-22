package com.playground.domain;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.statistics.HealthPoints;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.playground.domain.PangomonScenari.aPangomon;
import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    // TODO: add tests
    @Nested
    class HealthPointTests {
        @Test
        void pangomonWith1BaseHPAndLevel1_shouldHave11HPMax() {
            // given
            HealthPoints healthPoints = new HealthPoints(new Level(1), 1, 0, 0, 0);

            // when
            Pangomon pangomon = aPangomon()
                    .withLevel(1)
                    .withHealthPoints(healthPoints)
                    .build();

            // then
            assertThat(pangomon.healthPoints().max()).isEqualTo(11);
        }

        @Test
        void pangomonWith255BaseHPAndLevel1_shouldHave16HPMax() {
            // given
            HealthPoints healthPoints = new HealthPoints(new Level(1), 255, 0, 0, 0);

            // when
            Pangomon pangomon = aPangomon()
                    .withLevel(1)
                    .withHealthPoints(healthPoints)
                    .build();

            // then
            assertThat(pangomon.healthPoints().max()).isEqualTo(16);
        }
    }
}
