package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.dao.TransSessionContext;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.zfba.dao.ent.SysOperLogMapper;
import com.maxvision.zfba.module.ent.SysOperLog;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysOperLogVo;
import com.maxvision.zfba.pub.DBS;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * @author minte
 */
@Component
public class SysOperatorLogService {


    public ResultPage<List<SysOperLog>> page(MapperContext mc, SysOperLogVo vo) {
        QueryExample query = new QueryExample();
        query.setIgnoreEmpty(true);
        query.or().addCriterion("s.oper_time >=", vo.getStarTime())
        .addCriterion("s.oper_time <=", vo.getEndTime())
        .addCriterion("s.login_id=", vo.getLoginId())
        .addCriterion("s.oper_action=", vo.getOperAction());
        query.setOrderByClause("s.oper_time DESC");
        SysOperLogMapper mapper = mc.getMapper(SysOperLogMapper.class);
        RowBounds rb =  ResultPage.bounds(vo.getPage(), vo.getRows());
        List<SysOperLog> list = mapper.selectByExample(query, rb);
        int total = mapper.countByExample(query);
        return ResultPage.page(list, total);
    }

    public int save(SysOperLog handlerLog) {
        TransSessionContext session = DBS.openSqlSession(DBS.datasource, true);
        try {
            SysOperLogMapper mapper = session.getMapper(SysOperLogMapper.class);
            handlerLog.setOperId(RandomUtils.randomUUID());
            handlerLog.setOperTime(new Date());
            return mapper.insert(handlerLog);
        } finally {
            session.close();
        }
    }


}
