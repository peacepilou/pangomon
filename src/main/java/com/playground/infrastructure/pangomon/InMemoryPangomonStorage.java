package com.playground.infrastructure.pangomon;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.PangomonFactory;
import com.playground.domain.pangomon.Progression;
import com.playground.domain.pangomon.driven.PangomonStorage;
import com.playground.domain.pangomon.statistics.Bases;
import com.playground.domain.pangomon.statistics.EffortValues;
import com.playground.domain.pangomon.statistics.IndividualValues;

import java.util.List;
import java.util.UUID;

import static com.playground.domain.pangomon.Nature.BASHFUL;

public class InMemoryPangomonStorage implements PangomonStorage {
    // This is to fake the database
    // Theoretically, you'll use the ORM "repository" with the included methods
    private final List<PangomonEntity> inMemoryPangomons;

    public InMemoryPangomonStorage(List<PangomonEntity> inMemoryPangomons) {
        this.inMemoryPangomons = inMemoryPangomons;
    }

    @Override
    public Pangomon save(Pangomon pangomon) {
        PangomonEntity entity = toEntity(pangomon);
        inMemoryPangomons.add(entity);
        // This is to fake the fact you get something from the DB
        // and convert it to domain object
        return inMemoryPangomons.stream()
                .filter(pango -> pango.id().equals(entity.id()))
                .map(this::toDomain)
                .findFirst()
                .orElseThrow();
    }

    private PangomonEntity toEntity(Pangomon pangomon) {
        return new PangomonEntity(
                pangomon.getId().toString(),
                pangomon.getName(),
                pangomon.getType(),
                pangomon.getProgression().level().value(),
                pangomon.getProgression().experience(),
                pangomon.getHealthPoints().current(),
                0, 0, 0
        );
    }

    // TODO: fix health points
    private Pangomon toDomain(PangomonEntity entity) {
        return PangomonFactory.createPangomon(
                UUID.fromString(entity.id()),
                entity.name(),
                entity.type(),
                new Progression(new Level(entity.level()), entity.xp()),
                new Bases(0, 0, 0, 0, 0, 0),
                new IndividualValues(0, 0, 0, 0, 0, 0),
                new EffortValues(0, 0, 0, 0, 0, 0),
                BASHFUL
        );
//        return new Pangomon(
//                UUID.fromString(entity.id()),
//                entity.name(),
//                entity.type(),
//                new Progression(new Level(entity.level()), entity.xp()),
//                new HealthPoints(new Level(entity.level()), 0, 0, 0, 0),
//                entity.attack(),
//                entity.defense(),
//                entity.speed()
//        );
    }
}
