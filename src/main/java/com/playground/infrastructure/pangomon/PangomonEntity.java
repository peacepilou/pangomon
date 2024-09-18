package com.playground.infrastructure.pangomon;

public record PangomonEntity(
        String id,
        String name,
        String type,
        int level,
        int xp,
        int pv,
        int attack,
        int defense,
        int speed
) {
}
