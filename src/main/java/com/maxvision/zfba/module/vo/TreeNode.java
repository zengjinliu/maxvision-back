package com.maxvision.zfba.module.vo;

import com.maxvision.core.client.utils.CollectionUtils;
import com.maxvision.core.client.utils.StringUtils;
import com.maxvision.zfba.module.ent.SysMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author minte
 * @date 2020/12/12 17:34
 */
public class TreeNode<T> implements Serializable, Comparable<TreeNode<T>> {
    private static final long serialVersionUID = -4531621317121278348L;
    /**节点Id*/
    private String id;
    /**上级节点id*/
    private String pid;
    /**节点名称*/
    private String name;
    /**节点icon*/
    private String icon;
    /**节点链接*/
    private String url;
    /**节点数据*/
    private T nodeData;
    /**是否为叶子节点*/
    private boolean isLeaf = true;
    /**排序号*/
    private Integer orderNum;
    /**子级节点*/
    private List<TreeNode<T>> children = new ArrayList<TreeNode<T>>();

    public static <T> List<TreeNode<T>> buildTree(List<TreeNode<T>> nodes) {
        if (CollectionUtils.isEmpty(nodes)) {
            return null;
        }
        if (nodes.size() == 1) {
            return nodes;
        }
        // 用来存放nodes里面的顶级树节点
        // 也就是把没有父节点的节点都放到tops里面去
        List<TreeNode<T>> tops = new ArrayList<TreeNode<T>>();
        boolean hasParent = false;
        // 第一次遍历，获取一个节点作为子节点
        for (TreeNode<T> child : nodes) {
            hasParent = false;
            // 当前节点child的父节点id
            String pid = child.getPid();
            // 如果pid不存在或为空
            // 则当前节点为顶级节点
            if (StringUtils.isNullOrEmpty(pid)) {
                // 把当前节点添加到tops中作为顶级节点
                tops.add(child);
                // 跳过当前节点，进入下一轮
                continue;
            }
            // 遍历nodes上的所有节点，判断是否有child的父节点
            for (TreeNode<T> parent : nodes) {
                String id = parent.getId();
                // 如果parent节点的id等于child节点的pid，则parent节点是child节点的父节点
                if (id != null && id.equals(pid)) {
                    // 把child加到parent下
                    parent.getChildren().add(child);
                    parent.setLeaf(false);
                    // child节点有父节点
                    hasParent = true;
                    continue;
                }
            }
            // 如果child节点没有父节点，则child是顶级节点
            // 把child添加到tops中
            if (!hasParent) {
                tops.add(child);
            }
        }
        return tops;
    }


    /**
     * 从低到高排序
     * @param nodes
     * @param <T>
     * @return
     */
    public static <T> List<TreeNode<T>> sortedNatural(List<TreeNode<T>> nodes){
        List<TreeNode<T>> treeNodes = buildTree(nodes);
        if(treeNodes == null){
            return null;
        }
        return sortTree(treeNodes);
    }

    /**
     * 从高到低排序
     * @param nodes
     * @param <T>
     * @return
     */
    public static <T> List<TreeNode<T>> sortedReversed(List<TreeNode<T>> nodes){
        List<TreeNode<T>> treeNodes = buildTree(nodes);
        if(treeNodes == null){
            return null;
        }
        return sortTree1(treeNodes);
    }

    private static <T> List<TreeNode<T>> sortTree(List<TreeNode<T>> nodes){
        List<TreeNode<T>> list = sort(nodes);
        list.stream().forEach(e->{
            if(!CollectionUtils.isEmpty(e.getChildren())){
                e.setChildren(e.getChildren().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()));
                sortTree(e.getChildren());
            }
        });
        return list;
    }
    private static <T> List<TreeNode<T>> sortTree1(List<TreeNode<T>> nodes){
        List<TreeNode<T>> list = sort1(nodes);
        list.stream().forEach(e->{
            if(!CollectionUtils.isEmpty(e.getChildren())){
                e.setChildren(e.getChildren().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
                sortTree(e.getChildren());
            }
        });
        return list;
    }


    private static <T> List<TreeNode<T>> sort(List<TreeNode<T>> nodes) {
        List<TreeNode<T>> list = nodes.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        return list;
    }

    private static <T> List<TreeNode<T>> sort1(List<TreeNode<T>> nodes) {
        List<TreeNode<T>> list = nodes.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode<T>> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    public T getNodeData() {
        return nodeData;
    }

    public void setNodeData(T nodeData) {
        this.nodeData = nodeData;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public int compareTo(TreeNode<T> o) {
        Integer orderNum = o.getOrderNum();
        return this.orderNum.compareTo(orderNum);
    }

}
