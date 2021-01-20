package com.maxvision.zfba.service.sys;

import com.maxvision.core.ioc.annotation.Component;
import com.maxvision.core.mybatis.QueryExample;
import com.maxvision.core.server.pub.MapperContext;
import com.maxvision.zfba.constants.ZyConstant;
import com.maxvision.zfba.dao.ent.SysMenuMapper;
import com.maxvision.zfba.dao.ent.SysRoleMapper;
import com.maxvision.zfba.dao.ent.SysUserMapper;
import com.maxvision.zfba.module.ent.SysMenu;
import com.maxvision.zfba.module.ent.SysRole;
import com.maxvision.zfba.module.ent.SysUser;

import com.maxvision.zfba.module.vo.TreeNode;
import com.maxvision.zfba.util.CommonUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author minte
 * @date 2021/1/15 22:50
 */
@Component
public class SysMenuService {


    /**
     * 获取左侧菜单栏
     *
     * @return
     */
    public List<TreeNode<SysMenu>> getSideMenu(MapperContext mc, String userId) {
        if (ZyConstant.SYS_ADMIN_ROLE.equals(userId)) {
            List<SysMenu> query = this.query(mc, new SysMenu());
            return this.getSideMenu(query);
        }
        return this.getSideMenuByRole(mc, userId);
    }

    public List<SysMenu> query(MapperContext mc, SysMenu sysMenu) {
        SysMenuMapper mapper = mc.getMapper(SysMenuMapper.class);
        QueryExample qe = new QueryExample();
        qe.or().addLikeCriterion("s.menu_name = ", sysMenu.getMenuName());
        List<SysMenu> sysMenus = mapper.selectByExample(qe);
        return sysMenus;
    }

    /**
     * 构建菜单树
     *
     * @param sysMenus
     * @return
     */
    private List<TreeNode<SysMenu>> getSideMenu(List<SysMenu> sysMenus) {
        List<TreeNode<SysMenu>> nodeList = sysMenus.stream().map(menu -> {
            TreeNode<SysMenu> node = new TreeNode<>();
            node.setId(menu.getMenuId());
            node.setPid(menu.getParentId());
            node.setName(menu.getMenuName());
            node.setNodeData(menu);
            node.setIcon(menu.getIcon());
            node.setUrl(menu.getUrl());
            node.setType(menu.getType());
            return node;
        }).collect(Collectors.toList());
        return TreeNode.buildTree(nodeList);
    }

    /**
     * 通过用户Id-->角色查出该角色拥有的菜单树
     *
     * @return
     */
    private List<TreeNode<SysMenu>> getSideMenuByRole(MapperContext mc, String userId) {
        SysUserMapper mapper = mc.getMapper(SysUserMapper.class);
        SysRoleMapper roleMapper = mc.getMapper(SysRoleMapper.class);
        SysUser user = mapper.getByPrimaryKey(userId);
        String roleId = user.getRoleId();
        List<String> roeIds = CommonUtils.PATTERN.splitAsStream(roleId)
                .map(roleMapper::getByPrimaryKey)
                .map(SysRole::getRoleId)
                .collect(Collectors.toList());
        return this.getSideMenu(queryByRoleId(mc, roeIds));
    }


    /**
     * 根据用户角色查询所有菜单
     *
     * @param mc
     * @param roleId
     * @return
     */
    private List<SysMenu> queryByRoleId(MapperContext mc, List<String> roleId) {
        SysRoleMapper roleMapper = mc.getMapper(SysRoleMapper.class);
        SysMenuMapper mapper = mc.getMapper(SysMenuMapper.class);
        //获取角色对应的所有菜单
        Set<String> set = roleId.stream().map(roleMapper::getByPrimaryKey).map(SysRole::getMenuId).collect(Collectors.toSet());
        return set.stream().map(mapper::getByPrimaryKey).collect(Collectors.toList());
    }


}
