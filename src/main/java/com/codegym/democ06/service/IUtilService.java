package com.codegym.democ06.service;

import java.util.List;

public interface IUtilService<E> {
    List<E> findAll();
    boolean delete(Long id);
    boolean save(E object);
    boolean update(E object);
    E findById(Long id);
}
