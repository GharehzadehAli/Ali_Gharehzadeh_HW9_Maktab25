package com.example.core.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<E extends Serializable> {

    void create(E e);

    E update(E e);

    E read(Serializable id);

    void delete(Serializable id);
    List searchByName(String string);

}
