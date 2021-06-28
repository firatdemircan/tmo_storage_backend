package com.works.services;

import com.works.utils.Result;

import java.util.List;

public interface IBaseService<T> {

    Result<T> Save(T t);
    Result<T> Update(T t);
    Result<T> getById(int id);
    Result<List<T>> getAll();

}
