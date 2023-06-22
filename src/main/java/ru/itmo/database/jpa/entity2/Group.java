package ru.itmo.database.jpa.entity2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Setter
@Getter

@Entity
@Table(name = "tb_groups")
public class Group extends Unique{

    @Column(nullable = false)
    private String active;
    @Column(nullable = false)
    private LocalDateTime begin;
    @Column(nullable = false)
    private LocalDateTime finish;

    public Group(Hill hill, LocalDateTime begin, LocalDateTime finish) {
        this.hill = hill;
        this.begin = begin;
        this.finish = finish;
    }

    @ManyToMany
    @JoinTable(name = "alpin_group",
    joinColumns = @JoinColumn(name = "group_id"),
    inverseJoinColumns = @JoinColumn(name = "alpin_id"))
    private ArrayList<Alpin> alpins;

    @ManyToOne
    private Hill hill;

}



