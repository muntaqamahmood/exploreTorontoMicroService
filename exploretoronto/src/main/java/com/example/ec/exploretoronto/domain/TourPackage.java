package com.example.ec.exploretoronto.domain;

import java.util.UUID;


public class TourPackage {
    private UUID code;
    private String name;

    public UUID getCode() {
        return code;
    }
    public void setCode(UUID code) {
        this.code = code;
    }
}
