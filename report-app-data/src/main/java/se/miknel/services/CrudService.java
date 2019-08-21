package se.miknel.services;

import se.miknel.model.BaseEntity;

import java.util.List;

public interface CrudService<T extends BaseEntity, ID extends Long> {
    List<T> findAll();
    T findById(ID id);
    T save(T object);
    void deleteById(ID id);


}
