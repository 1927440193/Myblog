package com.hu.service;


import com.hu.pojo.FriendLink;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 友链业务层接口
 * @Package com.hu.service
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
public interface FriendLinkService {

    //查询所有友链
    List<FriendLink> listFriendLink();

    //友链新增
    int saveFriendLink(FriendLink friendLink);

    //根据id查询友链
    FriendLink getFriendLink(Long id);

    //根据网址查询友链
    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    //编辑修改友链
    int updateFriendLink(FriendLink friendLink);

    //删除友链
    void deleteFriendLink(Long id);


}