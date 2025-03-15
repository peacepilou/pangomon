package com.playground.domain.fight;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

class FightTest {


    @Nested
    class Initiative {

        @RepeatedTest(100)
        void playerPangomon_ShouldFightFirst_WhenItHasHigherSpeed() {
            // given
//            Pangomon playerPangomon = aPangomon().withSpeed(20).build();
//            Pangomon iAPangomon = aPangomon().withSpeed(10).build();
//
//            Fight fight = new Fight(iAPangomon, playerPangomon);
//
//            // when
//            // then
//            assertThat(fight.initiativeOrder().getFirst())
//                    .isEqualTo(playerPangomon);
        }

        // TODO : need to tag which pangomon is the player's one
        /*@RepeatedTest(100)
        void IAPangomon_ShouldFightFirst_WhenBothHasSameSpeed() {
            // given
            Pangomon playerPangomon = withSpeed(20);
            Pangomon iAPangomon = withSpeed(20);

            Fight fight = new Fight(iAPangomon, playerPangomon);

            // when
            // then
            assertThat(fight.initiativeOrder().get(0))
                    .usingRecursiveComparison()
                    .ignoringFieldsOfTypes(UUID.class)
                    .isEqualTo(iAPangomon);
        }*/

    }

    @Nested
    class Attack {


    }


}