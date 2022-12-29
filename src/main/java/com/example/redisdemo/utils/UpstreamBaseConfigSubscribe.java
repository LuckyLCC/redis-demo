package com.example.redisdemo.utils;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import java.util.List;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-09-29  09:41
 */
public class UpstreamBaseConfigSubscribe implements MessageListener {

    private static UpstreamBaseConfigSubscribe instance;

    private UpstreamBaseConfigSubscribe(){}



    public static UpstreamBaseConfigSubscribe getInstance() {
        if (instance == null) {
            synchronized (UpstreamBaseConfigSubscribe.class) { // 此处为类级别的锁
                if (instance == null) {
                    instance = new UpstreamBaseConfigSubscribe();
                }
            }
        }
        return instance;
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {

        System.out.println("订阅频道:" + new String(message.getChannel()));
        System.out.println("接收数据:" + new String(message.getBody()));
    }
}
