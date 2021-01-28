package com.maxvision.zfba.service.sys;


import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.zfba.dao.ent.SysUserMapper;
import com.maxvision.zfba.module.ent.SysUser;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysUserVo;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * @author minte
 * @date 2021/1/15 9:14
 */
@Component
public class SysUserService {

    public ResultPage<List<SysUser>> page(MapperContext mc, SysUserVo userVo) {
        QueryExample query = new QueryExample();
        query.setIgnoreEmpty(true);
        query.or().addLikeCriterion("s.user_name", userVo.getUserName());
        query.or().addLikeCriterion("s.login_name", userVo.getLoginName());
        query.setOrderByClause("s.create_time desc");
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        RowBounds rb = ResultPage.bounds(userVo.getPage(), userVo.getRows());
        List<SysUser> list = mapper.selectByExample(query, rb);
        int count = mapper.countByExample(query);
        return ResultPage.page(list,count);
    }

    public int delete(MapperContext mc, List<String> userId) {
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        if(!CollectionUtils.isEmpty(userId)){
            return (int) userId.stream().map(mapper::deleteByPrimaryKey).count();
        }
        return -1;
    }

    public int update(MapperContext mc, SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        return mapper.updateByPrimaryKeySelective(sysUser);
    }

    public List<SysUser> query(MapperContext mc, SysUser sysUser) {
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        QueryExample qe = new QueryExample();
        qe.or().addCriterion("s.user_name = ", sysUser.getUserName());
        qe.or().addCriterion("s.login_name = ", sysUser.getLoginName());
        return mapper.selectByExample(qe);
    }

    public SysUser queryByUsername(MapperContext mc, String loginName) {
        SysUser user = new SysUser();
        user.setLoginName(loginName);
        List<SysUser> list = this.query(mc, user);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }

    public SysUser queryByPrimaryKey(MapperContext mc, String userId) {
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        return mapper.getByPrimaryKey(userId);
    }

    public int save(MapperContext mc, SysUser user) {
        user.setCreateTime(new Date());
        user.setUserId(RandomUtils.randomUUID());
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        user.setPassword(StringUtils.md5(user.getPassword()).toLowerCase());
        return mapper.insert(user);
    }

    /**
     * 校验登陆账户是否已经存在
     * @param mc mapper
     * @param loginName 登陆账户名
     * @return true 存在，false,不存在
     */
    public boolean checkLoginNameExist(MapperContext mc, String loginName) {
        SysUser user = new SysUser();
        user.setLoginName(loginName);
        List<SysUser> list = this.query(mc, user);
        return !CollectionUtils.isEmpty(list);
    }
}
