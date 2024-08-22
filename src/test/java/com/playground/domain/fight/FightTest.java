package com.playground.domain.fight;

import com.playground.domain.pangomon.Pangomon;
import org.junit.jupiter.api.Test;

import static com.playground.domain.PangomonScenari.withSpeed;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FightTest {

    @Test
    void playerPangomon_ShouldFightFirst_WhenItHasHigherSpeed() {
        // given
        Pangomon playerPangomon = withSpeed(20);
        Pangomon IAPangomon = withSpeed(10);

        Fight fight = new Fight(IAPangomon, playerPangomon);

        // when
        // then
        assertEquals(playerPangomon, fight.initiativeOrder().get(0));
    }

    @Test
    void IAPangomon_ShouldFightFirst_WhenBothHasSameSpeed() {
        // given
        Pangomon playerPangomon = withSpeed(20);
        Pangomon IAPangomon = withSpeed(20);

        Fight fight = new Fight(IAPangomon, playerPangomon);

        // when
        // then
        assertEquals(IAPangomon, fight.initiativeOrder().get(0));
    }
}