package com.example.generalairport.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.domain.Persistable;

import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity<P extends Serializable> implements Persistable<P>, Serializable {
    private static final long serialVersionUID = -4175419583609013727L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected P id;

    @Override
    public P getId() {
        return id;
    }

    public BaseEntity<P> setId(P id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean isNew() {
        return this.id == null;
    }
}
