package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.Criteria;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.zfba.dao.ent.SysDictDataMapper;
import com.maxvision.zfba.dao.ent.SysDictDataMapper;
import com.maxvision.zfba.module.ent.SysDictData;
import com.maxvision.zfba.module.ent.SysDictData;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysDictDataVo;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * @author minte
 */
@Component
public class SysDictDataService {

    public ResultPage<List<SysDictData>> page(MapperContext mc, SysDictDataVo sysDictDataVo) {
        QueryExample query = new QueryExample();
        query.setIgnoreEmpty(true);
        Criteria criteria = query.or().addCriterion("s.dict_type = ", sysDictDataVo.getDictType());
        if(!StringUtils.isNullOrEmpty(sysDictDataVo.getDictLabel())){
            criteria.addLikeCriterion("s.dict_label", sysDictDataVo.getDictLabel());
        }
        query.setOrderByClause("s.create_time desc");
        SysDictDataMapper mapper = mc.getMapper(SysDictDataMapper.class);
        RowBounds rb = ResultPage.bounds(sysDictDataVo.getPage(), sysDictDataVo.getRows());
        List<SysDictData> list = mapper.selectByExample(query, rb);
        int count = mapper.countByExample(query);
        return ResultPage.page(list,count);
    }


    public int add(MapperContext mc, SysDictData sysDictData){
        SysDictDataMapper mapper = mc.getMapper(SysDictDataMapper.class);
        sysDictData.setDictCode(RandomUtils.randomUUID());
        sysDictData.setCreateTime(new Date());
        return mapper.insert(sysDictData);
    }

    public int delete(MapperContext mc,List<String> dictCodes){
        SysDictDataMapper mapper = mc.getMapper(SysDictDataMapper.class);
        if(!CollectionUtils.isEmpty(dictCodes)){
            return (int) dictCodes.stream().map(mapper::deleteByPrimaryKey).count();
        }
        return -1;
    }

    public int update(MapperContext mc, SysDictData sysDictData){
        SysDictDataMapper mapper = mc.getMapper(SysDictDataMapper.class);
        sysDictData.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(sysDictData);
    }

    public SysDictData queryById(MapperContext mc,String dictCode){
        SysDictDataMapper mapper = mc.getMapper(SysDictDataMapper.class);
        return mapper.getByPrimaryKey(dictCode);
    }
    
    
}
