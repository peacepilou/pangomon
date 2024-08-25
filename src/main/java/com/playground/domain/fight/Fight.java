package com.playground.domain.fight;

import com.playground.domain.pangomon.Pangomon;

import java.util.List;
import java.util.stream.Stream;

public record Fight(
        Pangomon playerPangomon,
        Pangomon IAPangomon
) {

    public List<Pangomon> initiativeOrder() {
        return Stream.of(playerPangomon, IAPangomon)
                .sorted((p1, p2) -> p2.speed() - p1.speed())
                .sorted((p1, p2) -> p2.id().compareTo(p1.id()))
                .toList();
    }
}
