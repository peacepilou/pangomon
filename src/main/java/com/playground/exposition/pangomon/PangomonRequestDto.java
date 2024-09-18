package com.playground.exposition.pangomon;

public record PangomonRequestDto(
        // Classic INPUT (come from outside) DTO
        // with json serialization and so on
        String id,
        String name,
        String type,
        ProgressionRequestDto progression,
        int pv,
        int attack,
        int defense,
        int speed
) {
}

record ProgressionRequestDto(
        int level,
        int xp
) {
}
