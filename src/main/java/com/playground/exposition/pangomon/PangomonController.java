package com.playground.exposition.pangomon;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.PangomonFactory;
import com.playground.domain.pangomon.Progression;
import com.playground.domain.pangomon.driving.PangomonService;
import com.playground.domain.pangomon.statistics.Bases;
import com.playground.domain.pangomon.statistics.EffortValues;
import com.playground.domain.pangomon.statistics.IndividualValues;

import java.util.UUID;

import static com.playground.domain.pangomon.Nature.BASHFUL;

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
        return PangomonFactory.createPangomon(
                UUID.fromString(requestDto.id()),
                requestDto.name(),
                requestDto.type(),
                progression,
                new Bases(0, 0, 0, 0, 0, 0),
                new IndividualValues(0, 0, 0, 0, 0, 0),
                new EffortValues(0, 0, 0, 0, 0, 0),
                BASHFUL
        );
    }

    private PangomonResponseDto toResponseDto(Pangomon pangomon) {
        // Convert a Pangomon to a PangomonResponseDto
        return new PangomonResponseDto(
                pangomon.getId().toString(),
                pangomon.getName(),
                pangomon.getType(),
                new ProgressionResponseDto(pangomon.getProgression().level().value(), pangomon.getProgression().experience()),
                pangomon.getHealthPoints().current(),
                0, 0, 0
        );
    }
}
