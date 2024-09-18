package com.playground.exposition.pangomon;

public record PangomonResponseDto(
        // Classic OUTPUT (go outside) DTO
        // with json serialization and so on
        String id,
        String name,
        String type,
        ProgressionResponseDto progression,
        int pv,
        int attack,
        int defense,
        int speed
) {
}

record ProgressionResponseDto(
        int level,
        int xp
) {
}