package com.maxvision.zfba.jobs;


import com.maxvision.zfba.pub.DBS;
import com.maxvision.core.ioc.IocContextUtils;
import com.maxvision.core.server.dao.TransSessionContext;
import com.maxvision.core.server.jobs.Job;
import com.maxvision.core.web.WebContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 同步关区代码信息
 * @author minte
 * @date 2020/10/12 10:51
 */
public class SyncCustomCodeJob implements Job {

    private static final Logger logger = LogManager.getLogger(SyncCustomCodeJob.class);

    @Override
    public String name() {
        return "SyncCustomCodeJob";
    }

    @Override
    public Job execute(String[] strings) {
        WebContext context = IocContextUtils.getContext();
        //服务尚未启动完成
        if (context == null) {
            return this;
        }
        //获取transactionSession
        TransSessionContext sqlSession = DBS.openSqlSession(DBS.datasource);
        try {

            sqlSession.commit();
        } catch (Exception e) {
           logger.error("sync customs code has error:{}",e.getMessage());
        }finally {
            sqlSession.close();
        }
        return this;
    }



}
