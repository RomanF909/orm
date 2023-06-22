package ru.itmo.database.jpa.entity2;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.ArrayList;

@Getter

@Entity
@Table(name = "tb_alpins")
public class Alpin extends Unique{
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String address;

    public Alpin(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

    @ManyToOne
    @JoinColumn(name = "hill_id", nullable = false)
    private Hill hill;

    @ManyToMany(mappedBy = "alpin_id", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private ArrayList<Group> grs;


}
