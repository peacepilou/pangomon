package com.playground.domain.pangomon;

import com.playground.domain.pangomon.driven.PangomonStorage;
import com.playground.domain.pangomon.driving.PangomonService;

public class CreatePangomonService implements PangomonService {
    private final PangomonStorage pangomonStorage;

    public CreatePangomonService(PangomonStorage pangomonStorage) {
        this.pangomonStorage = pangomonStorage;
    }

    @Override
    public Pangomon createPangomon(Pangomon pangomon) {
        Pangomon savedPangomon = pangomonStorage.save(pangomon);
        return savedPangomon;
    }
}
