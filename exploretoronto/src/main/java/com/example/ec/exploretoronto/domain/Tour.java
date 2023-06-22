package com.example.ec.exploretoronto.domain;

import jakarta.persistence.*;

@Entity
public class Tour {
    @Id
    @GeneratedValue
    private Integer id;
    @Column
    private String title;
    @Column(length = 2000)
    private String description;
    @Column(length = 2000)
    private String blurb;
    private Integer price;
    private Double duration;
    @Column(length = 2000)
    private String bullets;
    @Column
    private String keywords;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
