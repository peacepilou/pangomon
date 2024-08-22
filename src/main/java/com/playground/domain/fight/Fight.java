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
                // TODO: find how to discriminate the two Pangomons
                .sorted((p1, p2) -> p2.speed() - p1.speed())
                .toList();
    }
}
