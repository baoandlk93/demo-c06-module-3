package com.codegym.democ06.dao;

import java.util.List;

public interface BaseDAO<E> {
    List<E> findAll();
    boolean delete(Long id);
    boolean save(E object);
    boolean update(E object);
    E findById(Long id);
}
