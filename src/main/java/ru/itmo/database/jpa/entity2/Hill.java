package ru.itmo.database.jpa.entity2;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;

@Getter

@Entity
@Table(name = "tb_hill", indexes = @Index(columnList = "title", unique = true))
public class Hill {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private int high;

    public Hill(String title, String country, int high) {
        this.title = title;
        this.country = country;
        this.high = high;
    }

    @OneToMany
    private Group gr;
    @OneToMany
    private ArrayList<Alpin> alpins;

}
