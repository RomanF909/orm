package ru.itmo.database.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;

@Getter

@Entity
@Table(name = "tb_alpins", indexes = @Index(columnList = "fullName", unique = true))
public class Alpins {
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String adress;

    @ManyToMany
    @JoinTable(name = "alpins_hills",
            joinColumns = @JoinColumn(name = "alpins_fullname"),
            inverseJoinColumns = @JoinColumn(name = "hills_title"))
    private ArrayList<Hills> hill;

    @ManyToOne
    private Groups groups;

}
