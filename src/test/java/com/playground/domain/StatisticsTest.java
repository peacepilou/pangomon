package com.playground.domain;

import com.playground.domain.pangomon.Pangomon;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static com.playground.domain.PangomonScenari.aBasicPangomon;
import static com.playground.domain.PangomonScenari.aPangomon;
import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @Nested
    class HealthPointTests {


        @Test
        void pangomonWith50BaseHP_shouldGainOneHP_whenIncrease() {
            // given
            Pangomon pangomon = aPangomon()
                    .withLevel(1)
                    .withBaseHealthPoints(50)
                    .build();
            // then
            assertThat(pangomon.healthPoints().increase().value()).isEqualTo(11);
        }

        @Test
        void pangomonWith49BaseHP_shouldNotGainOneHP_whenIncrease() {
            // given
            Pangomon pangomon = aPangomon()
                    .withLevel(1)
                    .withBaseHealthPoints(49)
                    .build();
            // then
            assertThat(pangomon.healthPoints().increase().value()).isEqualTo(10);
        }

        @Test
        public void pangomonWith100Iv_shouldGain1MoreHP() {
            // given
            Pangomon pangomon = aPangomon()
                    .withLevel(1)
                    .withBaseHealthPoints(50)
                    .withIv(100)
                    .build();
            // then
            assertThat(pangomon.healthPoints().increase().value()).isEqualTo(12);
        }

        // TODO : rename method & add edge cases
        // TODO : Refacto : IV can't be valuated more than 31
        @Test
        public void foo() {
            // given
            Pangomon pangomon = aPangomon()
                    .withLevel(1)
                    .withBaseHealthPoints(50)
                    .withIv(99)
                    .build();
            // then
            assertThat(pangomon.healthPoints().increase().value()).isEqualTo(12);
        }
    }
}
