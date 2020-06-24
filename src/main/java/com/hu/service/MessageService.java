package com.hu.service;


import com.hu.pojo.Message;

import java.util.List;

/**
 * @author 胡学俊
 * @version V1.0
 * @Description 留言业务层接口
 * @Package com.hu.service
 * @date 2020/3/21
 * @QQ 1927440193
 * @Telephone 17852250129
 */
public interface MessageService {

    //查询留言列表
    List<Message> listMessage();

    //保存留言
    int saveMessage(Message message);

    //删除留言
    void deleteMessage(Long id);

}