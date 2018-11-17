package com.snowofsunflower.android.data.db.greendaoimpl;

import android.content.Context;

import com.snowofsunflower.android.data.db.core.IDBConfig;
import com.snowofsunflower.android.data.db.core.IOrmDb;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.QueryBuilder;

import static com.snowofsunflower.android.data.db.greendaoimpl.DaoMaster.dropAllTables;

/**
 *
 *
 *
 *
 */
public class GreenDaoHelper implements IOrmDb {
    private static final String TAG = GreenDaoHelper.class.getSimpleName();
    private volatile static GreenDaoHelper sManager;//多线程访问
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Context context;
    private IDBConfig mDbConfig;

    /**
     * 使用单例模式获得操作数据库的对象
     *
     * @return
     */
    public static GreenDaoHelper getInstance() {
        GreenDaoHelper instance = null;
        if (sManager == null) {
            synchronized (GreenDaoHelper.class) {
                if (instance == null) {
                    instance = new GreenDaoHelper();
                    sManager = instance;
                }
            }
        }
        return sManager;
    }

    /**
     * 初始化操作
     *
     * @param context
     * @param config
     */
    public void init(Context context, IDBConfig config) {
        this.context = context;
        this.mDbConfig = config;
    }

    /**
     * 判断是否存在数据库，如果没有则创建数据库
     *
     * @return
     */
    public DaoMaster getDaoMaster() {
        OpenHelper helper = new OpenHelper(context, mDbConfig.dbName(), null);
        if (daoMaster == null) {
            daoMaster = new DaoMaster(helper.getEncryptedWritableDb(mDbConfig.encryptKey()));
        }
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        if (daoSession == null) {
            daoSession = getDaoMaster().newSession();
        }
        return daoSession;
    }

    /**
     * 打开输出日志的操作,默认是关闭的
     */
    public void setDebug() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }

    /**
     * 关闭所有的操作,数据库开启的时候，使用完毕了必须要关闭
     */
    public void closeConnection() {
        closeDaoSession();
    }

    public void closeDaoSession() {
        if (daoSession != null) {
            daoSession.clear();
            daoSession = null;
        }
    }

    private class OpenHelper extends DaoMaster.OpenHelper {
        public OpenHelper(Context context, String name, android.database.sqlite.SQLiteDatabase.CursorFactory factory) {
            super(context, name, factory);
        }

        @Override
        public void onUpgrade(Database db, int oldVersion, int newVersion) {
            dropAllTables(db, true);
            onCreate(db);
          /*  MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
                @Override
                public void onCreateAllTables(Database db, boolean ifNotExists) {
                    DaoMaster.createAllTables(db, ifNotExists);
                }

                @Override
                public void onDropAllTables(Database db, boolean ifExists) {
                    DaoMaster.dropAllTables(db, ifExists);
                }
            }, InformationCacheInfoDao.class, UserDao.class, VehCacheInfoDao.class, VehicleInfoDao.class);*/
        }
    }
}

