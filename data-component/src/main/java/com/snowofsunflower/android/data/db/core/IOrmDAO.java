package com.snowofsunflower.android.data.db.core;

import java.util.List;

/**
 * Created by zhouztashin on 2018/11/5.
 */

public interface IOrmDAO {

    <T> boolean insert(T t);

    <T> boolean insertList(List<T> list);

    <T> boolean update(T t);

    <T> boolean update(T t, ORMKey key);

    <T> boolean delete(T t);

    <T> boolean delete(T t, ORMKey key);

    boolean deleteAll(Class cls);

    <T> List<T> getAll(Class cls);

    <T> T getOne(Class cls, ORMKey key);
}
