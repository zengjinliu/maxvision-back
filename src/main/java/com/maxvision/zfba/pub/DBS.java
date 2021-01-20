package com.maxvision.zfba.pub;

import java.sql.Connection;

import com.maxvision.core.server.dao.TransSessionContext;
import com.maxvision.core.server.dao.TransSessionManager;

/**
 * 数据源配置
 * @author minte
 * @date 2020/10/23 16:52
 */
public final class DBS {
    /**数据库名称*/
    public static final String datasource = "zfba";

    /**
     * 获取数据源上下文
     *
     * @return
     */
    public static TransSessionContext openSqlSession() {
        return TransSessionManager.manager.get(datasource, false);
    }

    public static TransSessionContext openSqlSession(String datasource) {
        return TransSessionManager.manager.get(datasource, false);
    }

    public static TransSessionContext openSqlSession(final String ds, final boolean autoCommit) {
        return TransSessionManager.manager.get(ds, autoCommit);
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection openConnection() {
        return TransSessionManager.manager.getConnection(datasource);
    }
}
