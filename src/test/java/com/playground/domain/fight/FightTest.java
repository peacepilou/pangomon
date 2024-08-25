package com.playground.domain.fight;

import com.playground.domain.pangomon.Pangomon;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static com.playground.domain.PangomonScenari.withSpeed;
import static org.assertj.core.api.Assertions.assertThat;

class FightTest {

    @Test
    void playerPangomon_ShouldFightFirst_WhenItHasHigherSpeed() {
        // given
        Pangomon playerPangomon = withSpeed(20);
        Pangomon IAPangomon = withSpeed(10);

        Fight fight = new Fight(IAPangomon, playerPangomon);

        // when
        // then
        assertThat(fight.initiativeOrder().get(0))
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(UUID.class)
                .isEqualTo(playerPangomon);
    }

    @Test
    void IAPangomon_ShouldFightFirst_WhenBothHasSameSpeed() {
        // given
        Pangomon playerPangomon = withSpeed(20);
        Pangomon IAPangomon = withSpeed(20);

        Fight fight = new Fight(IAPangomon, playerPangomon);

        // when
        // then
        assertThat(fight.initiativeOrder().get(0))
                .usingRecursiveComparison()
                .ignoringFieldsOfTypes(UUID.class)
                .isEqualTo(IAPangomon);
    }
}