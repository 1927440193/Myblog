package com.hu.dao;

import com.hu.pojo.FriendLink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 友链持久层接口
 * @Package com.hu.dao
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
@Mapper
@Repository
public interface FriendLinkDao {

    List<FriendLink> listFriendLink();

    int saveFriendLink(FriendLink friendLink);

    FriendLink getFriendLink(Long id);

    FriendLink getFriendLinkByBlogaddress(String blogaddress);

    int updateFriendLink(FriendLink friendLink);

    void deleteFriendLink(Long id);

}
