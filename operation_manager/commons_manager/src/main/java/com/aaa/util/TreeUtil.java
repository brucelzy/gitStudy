package com.aaa.util;



import com.aaa.entity.LayUiTree;
import com.aaa.entity.SysMenu;

import java.util.ArrayList;
import java.util.List;


public class TreeUtil {
    //将menu实体转换成layuitree实体
    public static LayUiTree fromMenuToTree(SysMenu menu){
        LayUiTree layUiTree = new LayUiTree();
        layUiTree.setId(menu.getMenuId());
        layUiTree.setUrl(menu.getUrl());
        layUiTree.setTitle(menu.getMenuName());
        return layUiTree;
    }
    //将有子菜单的封装到父菜单中
    public static LayUiTree  setTreeChilren(LayUiTree tree, List<SysMenu> menuList){
        List<LayUiTree> layUiTreechildren = new ArrayList<>();
        for (SysMenu menu:menuList){
            if (menu.getParentId()==tree.getId()){
                LayUiTree layUiTree= fromMenuToTree(menu);
                layUiTreechildren.add(setTreeChilren(layUiTree,menuList));
            }
        }
        tree.setChildren(layUiTreechildren);
        return tree;
    }
    //把传入的menu列表转换成父子关系层级tree实体
    public static List<LayUiTree> fromMenuListToTreeList(List<SysMenu> menuList){
        List<LayUiTree> layUiTreeList = new ArrayList<>();
        for (SysMenu menu : menuList){
            if (menu.getParentId()==0){
                LayUiTree tree = fromMenuToTree(menu);
                LayUiTree treeChilren = setTreeChilren(tree,menuList);
                layUiTreeList.add(treeChilren);
            }
        }
        return layUiTreeList;
    }
}
