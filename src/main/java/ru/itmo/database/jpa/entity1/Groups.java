package ru.itmo.database.jpa.entity1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter

@Entity
@Table(name = "tb_groups", indexes = @Index(columnList = "alpinist, hill", unique = true))
public class Groups {

    @Column(nullable = false)
    private Alpins alpinist;
    @Column(nullable = false)
    private Hills hill;
    @Column(nullable = false)
    private String activ;
    @Column(nullable = false)
    private LocalDateTime begin;
    @Column(nullable = false)
    private LocalDateTime finish;

    @OneToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private ArrayList<Alpins> alpins;

    @OneToMany(mappedBy = "gr", cascade = CascadeType.ALL)
    private ArrayList<Hills> hills;

}

