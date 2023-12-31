package ru.itmo.database.jpa.entity2;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@Getter

@MappedSuperclass
abstract public class Unique {
    @Id
    protected String code;

    public Unique() {}

    public Unique(String code) {
        this.code = code;
    }
}