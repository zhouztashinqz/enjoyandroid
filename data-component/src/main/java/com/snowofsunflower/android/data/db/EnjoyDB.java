package com.snowofsunflower.android.data.db;

import com.snowofsunflower.android.data.db.core.IOrmDAO;
import com.snowofsunflower.android.data.db.core.IOrmDb;
import com.snowofsunflower.android.data.db.greendaoimpl.GreenDao;
import com.snowofsunflower.android.data.db.greendaoimpl.GreenDaoHelper;

/**
 * Created by zhouztashin on 2018/11/5.
 */

public class EnjoyDB {


    /**
     * 初始化数据库
     */
    public static IOrmDb getDb() {
        return GreenDaoHelper.getInstance();
    }

    public static IOrmDAO getDao() {
        return GreenDao.getInstances(GreenDaoHelper.getInstance());
    }


}
