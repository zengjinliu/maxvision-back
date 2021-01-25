package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.zfba.dao.ent.SysPostMapper;
import com.maxvision.zfba.module.ent.SysPost;
import com.maxvision.zfba.module.vo.ResultPage;
import com.maxvision.zfba.module.vo.SysPostVo;
import org.apache.ibatis.session.RowBounds;

import java.util.Date;
import java.util.List;

/**
 * @author minte
 */
@Component
public class SysPostService {


    public ResultPage<List<SysPost>> page(MapperContext mc, SysPostVo postVo) {
        QueryExample query = new QueryExample();
        query.setIgnoreEmpty(true);
        query.or().addLikeCriterion("s.post_name", postVo.getPostName());
        query.setOrderByClause("s.create_time desc");
        SysPostMapper mapper = mc.getMapper(SysPostMapper.class);
        RowBounds rb = ResultPage.bounds(postVo.getPage(), postVo.getRows());
        List<SysPost> list = mapper.selectByExample(query, rb);
        int count = mapper.countByExample(query);
        return ResultPage.page(list,count);
    }

    public int delete(MapperContext mc, List<String> postId) {
        SysPostMapper mapper = mc.getMapper(SysPostMapper.class);
        if(!CollectionUtils.isEmpty(postId)){
            return (int) postId.stream().map(mapper::deleteByPrimaryKey).count();
        }
        return -1;
    }

    public int update(MapperContext mc, SysPost sysPost) {
        sysPost.setUpdateTime(new Date());
        SysPostMapper mapper = mc.getMapper(SysPostMapper.class);
        return mapper.updateByPrimaryKeySelective(sysPost);
    }

    public List<SysPost> query(MapperContext mc, SysPost sysPost) {
        SysPostMapper mapper = mc.getMapper(SysPostMapper.class);
        QueryExample qe = new QueryExample();
        qe.or().addCriterion("m.post_name = ", sysPost.getPostName());
        return mapper.selectByExample(qe);
    }


    public SysPost queryByPrimaryKey(MapperContext mc, String postId) {
        SysPostMapper mapper = mc.getMapper(SysPostMapper.class);
        return mapper.getByPrimaryKey(postId);
    }

    public int save(MapperContext mc, SysPost post) {
        post.setCreateTime(new Date());
        post.setPostId(RandomUtils.randomUUID());
        SysPostMapper mapper = mc.getMapper(SysPostMapper.class);
        return mapper.insert(post);
    }

}
