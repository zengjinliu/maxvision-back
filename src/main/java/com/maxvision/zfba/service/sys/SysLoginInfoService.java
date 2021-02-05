package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.zfba.dao.ent.SysLoginInfoMapper;
import com.maxvision.zfba.module.ent.SysLoginInfo;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysLoginInfoVo;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.ibatis.session.RowBounds;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

/**
 * 系统日志信息
 *
 * @author minte
 */
@Component
public class SysLoginInfoService {

    public ResultPage<List<SysLoginInfo>> page(MapperContext mc, SysLoginInfoVo vo) {
        QueryExample query = new QueryExample();
        query.setIgnoreEmpty(true);
        query.or().addLikeCriterion("s.login_name",vo.getLoginName());
        query.setOrderByClause("s.login_time desc");
        SysLoginInfoMapper mapper = mc.getMapper(SysLoginInfoMapper.class);
        RowBounds rb = ResultPage.bounds(vo.getPage(), vo.getRows());
        List<SysLoginInfo> list = mapper.selectByExample(query, rb);
        int total = mapper.countByExample(query);
        return ResultPage.page(list, total);
    }


    public int saveLoginLog(MapperContext mc, HttpServletRequest req, SysLoginInfo logininfor) throws UnknownHostException {
        String ip = InetAddress.getLocalHost().getHostAddress();
        // 获取客户端操作系统
        final UserAgent userAgent = UserAgent.parseUserAgentString(req.getHeader("User-Agent"));
        String os = userAgent.getOperatingSystem().getName();
        // 获取客户端浏览器
        String browser = userAgent.getBrowser().getName();
        logininfor.setIpaddr(ip);
        logininfor.setBrowser(browser);
        logininfor.setOs(os);
        return this.save(mc, logininfor);
    }

    private int save(MapperContext mc, SysLoginInfo sysLogininfor) {
        SysLoginInfoMapper mapper = mc.getMapper(SysLoginInfoMapper.class);
        sysLogininfor.setInfoId(RandomUtils.randomUUID());
        sysLogininfor.setLoginTime(new Date());
        return mapper.insert(sysLogininfor);
    }

}
