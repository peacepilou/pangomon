package com.playground.infrastructure.pangomon;

import com.playground.domain.pangomon.Level;
import com.playground.domain.pangomon.Pangomon;
import com.playground.domain.pangomon.Progression;
import com.playground.domain.pangomon.driven.PangomonStorage;

import java.util.List;
import java.util.UUID;

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
                pangomon.id().toString(),
                pangomon.name(),
                pangomon.type(),
                pangomon.progression().level().value(),
                pangomon.progression().experience(),
                pangomon.pv(),
                pangomon.attack(),
                pangomon.defense(),
                pangomon.speed()
        );
    }

    private Pangomon toDomain(PangomonEntity entity) {
        return new Pangomon(
                UUID.fromString(entity.id()),
                entity.name(),
                entity.type(),
                new Progression(new Level(entity.level()), entity.xp()),
                entity.pv(),
                entity.attack(),
                entity.defense(),
                entity.speed()
        );
    }
}
