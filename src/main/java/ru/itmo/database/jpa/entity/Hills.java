package ru.itmo.database.jpa.entity;
import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;

@Getter

@Entity
@Table(name = "tb_hills", indexes = @Index(columnList = "title", unique = true))
public class Hills {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private int high;

    @ManyToMany(mappedBy = "hills", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ArrayList<Alpins> alpin;

    @ManyToOne
    private Groups gr;
}
