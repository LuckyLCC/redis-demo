package com.example.redisdemo.utils;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-09-29  09:41
 */
public class MySubscribe implements MessageListener {


    @Override
    public void onMessage(Message message, byte[] pattern) {
        System.out.println("订阅频道:" + new String(message.getChannel()));
        System.out.println("接收数据:" + new String(message.getBody()));
    }
}
