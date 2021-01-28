package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.zfba.dao.ent.SysDictTypeMapper;
import com.maxvision.zfba.dao.ent.SysUserMapper;
import com.maxvision.zfba.module.ent.SysDictType;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysDictTypeVo;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * @author minte
 */
@Component
public class SysDictTypeService {


    /**
     * 分页查询
     * @param mc
     * @param sysDictTypeVo
     * @return
     */
    public ResultPage<List<SysDictType>> page(MapperContext mc, SysDictTypeVo sysDictTypeVo) {
        QueryExample query = new QueryExample();
        query.setIgnoreEmpty(true);
        query.or().addLikeCriterion("s.dict_name", sysDictTypeVo.getDictName());
        query.or().addCriterion("s.dict_type = ", sysDictTypeVo.getDictType());
        query.setOrderByClause("s.create_time desc");
        SysDictTypeMapper mapper = mc.getMapper(SysDictTypeMapper.class);
        RowBounds rb = ResultPage.bounds(sysDictTypeVo.getPage(), sysDictTypeVo.getRows());
        List<SysDictType> list = mapper.selectByExample(query, rb);
        int count = mapper.countByExample(query);
        return ResultPage.page(list,count);
    }

    public int add(MapperContext mc, SysDictType sysDictType){
        SysDictTypeMapper mapper = mc.getMapper(SysDictTypeMapper.class);
        sysDictType.setDictId(RandomUtils.randomUUID());
        sysDictType.setCreateTime(new Date());
        return mapper.insert(sysDictType);
    }

    public int delete(MapperContext mc,List<String> dictIds){
        SysDictTypeMapper mapper = mc.getMapper(SysDictTypeMapper.class);
        if(!CollectionUtils.isEmpty(dictIds)){
            return (int) dictIds.stream().map(mapper::deleteByPrimaryKey).count();
        }
        return -1;
    }

    public int update(MapperContext mc, SysDictType sysDictType){
        SysDictTypeMapper mapper = mc.getMapper(SysDictTypeMapper.class);
        sysDictType.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(sysDictType);
    }

    public SysDictType queryById(MapperContext mc,String dictId){
        SysDictTypeMapper mapper = mc.getMapper(SysDictTypeMapper.class);
        return mapper.getByPrimaryKey(dictId);
    }

    public List<SysDictType> query(MapperContext mc, SysDictType sysDictType){
        QueryExample qe = new QueryExample();
        SysDictTypeMapper mapper = mc.getMapper(SysDictTypeMapper.class);
        return  mapper.selectByExample(qe);
    }
}
