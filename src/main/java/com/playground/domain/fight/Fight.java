package com.playground.domain.fight;

import com.playground.domain.pangomon.Pangomon;

import java.util.List;
import java.util.stream.Stream;

public record Fight(
        Pangomon playerPangomon,
        Pangomon iAPangomon
) {

    public List<Pangomon> initiativeOrder() {
        return Stream.of(playerPangomon, iAPangomon)
            .sorted((p1, p2) -> p2.speed() - p1.speed())
            .toList();
    }

    public Pangomon pango1AttacksPango2(Pangomon attacker, Pangomon defender) {
        return defender.takeDamages(attacker.attack());

    }
}
