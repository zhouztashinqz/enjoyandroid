package com.snowofsunflower.android.data.db.greendaoimpl;

import com.snowofsunflower.android.data.db.core.IOrmDAO;
import com.snowofsunflower.android.data.db.core.ORMKey;

import java.util.List;

/**
 * Created by zhouztashin on 2018/11/5.
 */

public class GreenDao implements IOrmDAO {

    private static volatile GreenDao sDao;
    private GreenDaoHelper mGreenDAOHelper;

    private GreenDao(GreenDaoHelper greenDaoHelper) {
        mGreenDAOHelper = greenDaoHelper;
    }

    public static GreenDao getInstances(GreenDaoHelper greenDaoHelper) {
        synchronized (GreenDao.class) {
            if (sDao == null) {
                sDao = new GreenDao(greenDaoHelper);
            }
            return sDao;
        }
    }

    @Override
    public <T> boolean insert(T t) {
        if (mGreenDAOHelper == null) return false;
        boolean flag = false;
        try {
            flag = mGreenDAOHelper.getDaoSession().insert(t) != -1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public <T> boolean insertList(final List<T> list) {
        if (mGreenDAOHelper == null) return false;
        boolean flag = false;
        try {
            mGreenDAOHelper.getDaoSession().runInTx(new Runnable() {
                @Override
                public void run() {
                    for (T t : list) {
                        mGreenDAOHelper.getDaoSession().insertOrReplace(t);
                    }
                }
            });
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public <T> boolean update(T t) {
        if (mGreenDAOHelper == null) return false;
        boolean flag = false;
        try {
            mGreenDAOHelper.getDaoSession().update(t);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public <T> boolean update(T t, ORMKey key) {
        return false;
    }

    @Override
    public <T> boolean delete(T t) {
        if (mGreenDAOHelper == null) return false;
        boolean flag = false;
        try {
            mGreenDAOHelper.getDaoSession().delete(t);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public <T> boolean delete(T t, ORMKey key) {
        return false;
    }

    @Override
    public boolean deleteAll(Class cls) {
        if (mGreenDAOHelper == null) return false;
        boolean flag = false;
        try {
            mGreenDAOHelper.getDaoSession().deleteAll(cls);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public <T> List<T> getAll(Class cls) {
        if (mGreenDAOHelper == null) return null;
        List<T> list = null;
        try {
            return mGreenDAOHelper.getDaoSession().loadAll(cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public <T> T getOne(Class cls, ORMKey key) {
        return null;
    }
}
