package com.example.generalairport.assembler;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.PagedModel;

import java.util.*;

public abstract class AbstractDtoAssembler<T, D> {

    public abstract D toModel(T entity);

    public List<D> toModels(Iterable<T> entities) {
        Objects.requireNonNull(entities, "Entities must not be null!");
        List<D> result = new ArrayList<>();

        for (T entity : entities) {
            result.add(this.toModel(entity));
        }

        return result;
    }

    public Set<D> toSetModels(Iterable<T> entities) {
        Objects.requireNonNull(entities, "Entities must not be null!");
        Set<D> result = new HashSet<>();

        for (T entity : entities) {
            result.add(this.toModel(entity));
        }

        return result;
    }

    public PagedModel<D> toPagedModel(Page<T> page) {
        List<D> list = toModels(page.getContent());
        PagedModel.PageMetadata metadata = new PagedModel.PageMetadata(
            page.getSize(), page.getNumber(), page.getTotalElements(), page.getTotalPages());
        return PagedModel.of(list, metadata);
    }

}

