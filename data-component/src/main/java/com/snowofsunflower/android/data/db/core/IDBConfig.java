package com.snowofsunflower.android.data.db.core;

/**
 * Created by zhouztashin on 2018/11/5.
 */

public interface IDBConfig {

    String dbName();

    int version();

    String encryptKey();

}
