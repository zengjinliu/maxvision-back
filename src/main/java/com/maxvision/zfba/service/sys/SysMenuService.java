package com.maxvision.zfba.service.sys;

import com.maxvision.core.client.utils.RandomUtils;
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

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author minte
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

    public int save(MapperContext mc, SysMenu sysMenu){
        SysMenuMapper mapper = mc.getMapper(SysMenuMapper.class);
        sysMenu.setMenuId(RandomUtils.randomUUID());
        sysMenu.setCreateTime(new Date());
        return mapper.insert(sysMenu);
    }



    public List<SysMenu> query(MapperContext mc, SysMenu sysMenu) {
        SysMenuMapper mapper = mc.getMapper(SysMenuMapper.class);
        QueryExample qe = new QueryExample();
        qe.or().addLikeCriterion("s.menu_name", sysMenu.getMenuName());
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
            node.setOrderNum(menu.getOrderNum());
            return node;
        }).collect(Collectors.toList());
        return TreeNode.sortedNatural(nodeList);
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
        List<String> list = roleId.stream()
                .map(roleMapper::getByPrimaryKey)
                .map(SysRole::getMenuId)
                .collect(Collectors.toList());
        List<SysMenu> res = new ArrayList<>();
        list.forEach(e->CommonUtils.PATTERN.splitAsStream(e)
            .forEach(menuId->res.add(mapper.getByPrimaryKey(menuId))));
        return res;
    }

    /**
     * 根据主键删除菜单
     * @param id 菜单id
     * @return
     */
    public int deleteByMenuId(MapperContext mc, String id) {
        SysMenuMapper mapper = mc.getMapper(SysMenuMapper.class);
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键查询菜单
     * @param mc
     * @param menuId
     * @return
     */
    public SysMenu queryByMenuId(MapperContext mc, String menuId) {
        SysMenuMapper mapper = mc.getMapper(SysMenuMapper.class);
        return mapper.getByPrimaryKey(menuId);
    }

    /**
     * 根据主键更新菜单
     * @param mc
     * @param sysMenu
     * @return
     */
    public int update(MapperContext mc, SysMenu sysMenu) {
        SysMenuMapper mapper = mc.getMapper(SysMenuMapper.class);
        sysMenu.setUpdateTime(new Date());
        return mapper.updateByPrimaryKeySelective(sysMenu);
    }

    /**
     * 根据菜单名查询菜单
     * @param mc
     * @param menuName
     * @return
     */
    public List<TreeNode<SysMenu>> queryByMenuName(MapperContext mc, String menuName) {
        SysMenu menu = new SysMenu();
        menu.setMenuName(menuName);
        List<SysMenu> list = this.query(mc, menu);
        return this.getSideMenu(list);
    }
}
