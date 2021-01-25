package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.RandomUtils;
import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.zfba.dao.ent.SysDeptMapper;
import com.maxvision.zfba.module.ent.SysDept;
import com.maxvision.zfba.module.vo.TreeNode;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author minte
 */
@Component
public class SysDeptService {

    /**
     * 获取部门树形结构
     *
     * @return
     */
    public List<TreeNode<SysDept>> queryTreeDept(MapperContext mc) {
        List<SysDept> query = this.query(mc, new SysDept());
        return this.getTreeDept(query);
    }

    /**
     * 新增部门信息
     * @param mc
     * @param sysDept
     * @return
     */
    public int save(MapperContext mc, SysDept sysDept){
        SysDeptMapper mapper = mc.getMapper(SysDeptMapper.class);
        sysDept.setDeptId(RandomUtils.randomUUID());
        sysDept.setCreateTime(new Date());
        return mapper.insert(sysDept);
    }


    /**
     * 查询部门信息
     * @param mc
     * @param sysDept
     * @return
     */
    public List<SysDept> query(MapperContext mc, SysDept sysDept) {
        SysDeptMapper mapper = mc.getMapper(SysDeptMapper.class);
        QueryExample qe = new QueryExample();
        qe.or().addLikeCriterion("s.dept_name = ", sysDept.getDeptName());
        List<SysDept> sysDepts = mapper.selectByExample(qe);
        return sysDepts;
    }

    /**
     * 构建部门树
     *
     * @param sysDepts
     * @return
     */
    private List<TreeNode<SysDept>> getTreeDept(List<SysDept> sysDepts) {
        List<TreeNode<SysDept>> nodeList = sysDepts.stream().map(dept -> {
            TreeNode<SysDept> node = new TreeNode<>();
            node.setId(dept.getDeptId());
            node.setPid(dept.getParentId());
            node.setName(dept.getDeptName());
            node.setNodeData(dept);
            node.setOrderNum(dept.getOrderNum());
            return node;
        }).collect(Collectors.toList());
        return TreeNode.sortedNatural(nodeList);
    }

    /**
     * 根据主键删除部门
     * @param id 部门id
     * @return
     */
    public int deleteByDeptId(MapperContext mc, String id) {
        SysDeptMapper mapper = mc.getMapper(SysDeptMapper.class);
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键查询部门
     * @param mc
     * @param deptId
     * @return
     */
    public SysDept queryByDeptId(MapperContext mc, String deptId) {
        SysDeptMapper mapper = mc.getMapper(SysDeptMapper.class);
        return mapper.getByPrimaryKey(deptId);
    }

    /**
     * 根据主键更新部门
     * @param mc
     * @param sysDept
     * @return
     */
    public int update(MapperContext mc, SysDept sysDept) {
        SysDeptMapper mapper = mc.getMapper(SysDeptMapper.class);
        sysDept.setUpdateTime(new Date());
        return mapper.updateByPrimaryKey(sysDept);
    }



}
