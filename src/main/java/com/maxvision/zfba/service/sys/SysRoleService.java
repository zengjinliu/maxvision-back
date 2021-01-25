package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.core.utils.CollectionUtils;
import com.maxvision.zfba.dao.ent.SysRoleMapper;
import com.maxvision.zfba.module.ent.SysRole;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysRoleVo;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * @author minte
 * @date 2021/1/21 18:33
 */
@Component
public class SysRoleService {


    public ResultPage<List<SysRole>> page(MapperContext mc, SysRoleVo roleVo) {
        QueryExample query = new QueryExample();
        query.setIgnoreEmpty(true);
        query.or().addLikeCriterion("s.role_name", roleVo.getRoleName());
        query.setOrderByClause("s.create_time desc");
        SysRoleMapper mapper = mc.getMapper(SysRoleMapper.class);
        RowBounds rb = ResultPage.bounds(roleVo.getPage(), roleVo.getRows());
        List<SysRole> list = mapper.selectByExample(query, rb);
        int count = mapper.countByExample(query);
        return ResultPage.page(list,count);
    }

    public int save(MapperContext mc, SysRole role) {
        SysRoleMapper mapper = mc.getMapper(SysRoleMapper.class);
        role.setRoleId(RandomUtils.randomUUID());
        role.setCreateTime(new Date());
        return mapper.insert(role);
    }

    public int delete(MapperContext mc, List<String> roleIds) {
        SysRoleMapper mapper = mc.getMapper(SysRoleMapper.class);
        if(!CollectionUtils.isEmpty(roleIds)){
            return (int) roleIds.stream().map(mapper::deleteByPrimaryKey).count();
        }
        return -1;
    }

    public int update(MapperContext mc, SysRole role) {
        role.setUpdateTime(new Date());
        SysRoleMapper mapper = mc.getMapper(SysRoleMapper.class);
        return mapper.updateByPrimaryKeySelective(role);
    }

    public SysRole queryByPrimaryKey(MapperContext mc, String roleId) {
        SysRoleMapper mapper = mc.getMapper(SysRoleMapper.class);
        return mapper.getByPrimaryKey(roleId);
    }

    public List<SysRole> queryAllRole(MapperContext mc) {
        SysRoleMapper mapper = mc.getMapper(SysRoleMapper.class);
        QueryExample qe = new QueryExample();
        return mapper.selectByExample(qe);
    }
}
