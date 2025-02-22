package com.playground.exposition.pangomon;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;
import com.playground.domain.pangomon.driving.PangomonService;
import com.playground.domain.pangomon.statistics.HealthPoints;

import java.util.UUID;

public class PangomonController {
    private final PangomonService pangomonService;

    public PangomonController(PangomonService pangomonService) {
        this.pangomonService = pangomonService;
    }

    public PangomonResponseDto createPangomon(PangomonRequestDto requestDto) {
        Pangomon pangomon = toDomain(requestDto);
        Pangomon createdPangomon = pangomonService.createPangomon(pangomon);
        return toResponseDto(createdPangomon);
    }

    private Pangomon toDomain(PangomonRequestDto requestDto) {
        // Convert a PangomonRequestDto to a Pangomon
        Progression progression = new Progression(new Level(requestDto.progression().level()), requestDto.progression().xp());

        // TODO: change the DTO
        return new Pangomon(
                UUID.fromString(requestDto.id()),
                requestDto.name(),
                requestDto.type(),
                progression,
                new HealthPoints(progression.level(), 0, 0, 0, 0),
                requestDto.attack(),
                requestDto.defense(),
                requestDto.speed()
        );
    }

    private PangomonResponseDto toResponseDto(Pangomon pangomon) {
        // Convert a Pangomon to a PangomonResponseDto
        return new PangomonResponseDto(
                pangomon.id().toString(),
                pangomon.name(),
                pangomon.type(),
                new ProgressionResponseDto(pangomon.progression().level().value(), pangomon.progression().experience()),
                pangomon.healthPoints().current(),
                pangomon.attack(),
                pangomon.defense(),
                pangomon.speed()
        );
    }
}
