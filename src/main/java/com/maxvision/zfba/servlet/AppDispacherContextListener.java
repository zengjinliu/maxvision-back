package com.maxvision.zfba.servlet;

import com.maxvision.core.server.dao.MySqlSqlConditionFormater;
import com.maxvision.core.cache.Cacher;
import com.maxvision.core.client.utils.FileUtils;
import com.maxvision.core.mybatis.adapter.DefaultDbSessionFactoryBuilderImpl;
import com.maxvision.core.server.conf.loaders.Loadable;
import com.maxvision.core.server.dao.SqlConditionBuilder;
import com.maxvision.core.server.dao.TransSessionManager;
import com.maxvision.core.server.pub.AppEnvironment;
import com.maxvision.core.server.srv.ServiceManager;
import com.maxvision.core.server.srv.interval.IntervalService;
import com.maxvision.core.tasks.CleaupCacheTask;
import com.maxvision.core.utils.ClassUtils;
import com.maxvision.core.web.WebContext;
import com.maxvision.core.web.servlet.DispatcherContextListener;
import org.apache.logging.log4j.LogManager;
import com.maxvision.zfba.constants.CacheConstant;
import javax.servlet.ServletContext;
import java.lang.reflect.Constructor;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author yuechao
 */
public class AppDispacherContextListener extends DispatcherContextListener {
    /**
     * 初始化 web应用
     */
    @Override
    protected void beforeWebContextInitialize(final ServletContext sc) {
        // 设置时区
        TimeZone tz = TimeZone.getTimeZone("GMT+08");
        TimeZone.setDefault(tz);
        // 初始化环境变量
        Locale.setDefault(Locale.CHINA);
        //设置扫描包路径
        AppEnvironment.packageRoot = "com.maxvision.zfba";
        //设置扫描dao路径
        AppEnvironment.daoConfigPath = "com/maxvision/zfba/dao";
        // mybatis
        initMyBatis();
        // 数据库查询类型设置
        SqlConditionBuilder.setFormater(new MySqlSqlConditionFormater());

        // 监控配置文件
        final String confPath = FileUtils.combinePath(AppEnvironment.getAppPath(), AppEnvironment.relativeConfigRootPath);
        final List<Class<Loadable>> loadableClazzes = ClassUtils.loadSubClasses(Loadable.class);
        final List<Loadable> loadables = new LinkedList<Loadable>();
        final Class<?>[] parameterTypes = new Class<?>[]{String.class};
        for (Class<Loadable> clazz : loadableClazzes) {
            Loadable loadable = null;
            try {
                Constructor<Loadable> ctor = clazz.getConstructor(parameterTypes);
                loadable = ctor.newInstance(confPath);
            } catch (Exception e) {
                this.logger.error(e.toString());
            }
            if (loadable != null) {
                loadables.add(loadable);
            }
        }
        // 加载一次配置文件
        for (Loadable loadable : loadables) {
            loadable.doLoad();
        }
        // 启动系统服务
        ServiceManager.startup();
        // 监控配置文件
        IntervalService service = ServiceManager.get(IntervalService.class);
        if (service != null) {
            int delay = 60000;
            for (Loadable loadable : loadables) {
                service.schedule(loadable, delay);
            }
            // 定期删除缓存数据
            delay = 360000;
            service.schedule(new CleaupCacheTask(CacheConstant.ALL__VOLATILE_FIELD_KEYS), delay);
        }
    }

    @Override
    protected void webContextInitialized(final ServletContext sc, WebContext ctx) {
        //注册监听

    }

    @Override
    protected void destroy(final ServletContext sc) {
    	// 停止所有系统服务
        ServiceManager.shutdown();
        // 关闭缓存连接池
        Cacher.closePool();
        //关闭日志服务
        LogManager.shutdown();
     // 反注册jdbc drivers
 		Enumeration<Driver> drivers = DriverManager.getDrivers();
 		while (drivers.hasMoreElements()) {
 			Driver driver = drivers.nextElement();
 			try {
 				DriverManager.deregisterDriver(driver);
 				this.logger.info("deregistering jdbc driver: {}", driver);
 			} catch (SQLException ex) {
 				this.logger.info("error deregistering jdbc driver: {}", driver);
 			}
 		}
        super.destroy(sc);
    }

    /**
     * 加载 mybatis
     */
    private static final boolean initMyBatis() {
        TransSessionManager.manager.setBuilder(new DefaultDbSessionFactoryBuilderImpl());
        return TransSessionManager.manager.initializeStaticDatasource();
    }
}