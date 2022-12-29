package com.example.redisdemo.controller;

import com.alibaba.fastjson.JSON;
import com.example.redisdemo.domain.PlateForm;
import com.example.redisdemo.domain.UpstreamBaseConfig;
import com.example.redisdemo.mapper.PlateFormMapper;
import com.example.redisdemo.mapper.UpstreamBaseConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-09-29  09:42
 */

@RestController
@RequestMapping
public class RedisController {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private UpstreamBaseConfigMapper upstreamBaseConfigMapper;

    @Autowired
    private PlateFormMapper plateFormMapper;

    public static final String MESSAGE_ZKEY = "message:ZSetqueue";
    public volatile AtomicInteger count = new AtomicInteger();

    @GetMapping("/publish")
    public void publish(String data) {
        UpstreamBaseConfig upstreamBaseConfig = upstreamBaseConfigMapper.selectById(1);
        redisTemplate.convertAndSend("upstreambaseconfig", JSON.toJSONString(upstreamBaseConfig));
    }

    @GetMapping("/publish2")
    public void publish2(String data) {
        PlateForm plateForm = plateFormMapper.selectById(1);
        redisTemplate.convertAndSend("plateformsubscribe", JSON.toJSONString(plateForm));
    }


    @GetMapping("/publish3")
    public void publish3() {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                int increment = count.getAndIncrement();
//                System.out.println(Thread.currentThread().getName() + "：put message to zset = " + increment);
////                log.info(Thread.currentThread().getName() + "：put message to zset = " + increment);
//                double score = System.currentTimeMillis() + new Random().nextInt(60 * 1000);
//                redisTemplate.opsForZSet().add(MESSAGE_ZKEY, Thread.currentThread().getName() + " hello zset：" + increment, score);
//            }).start();
//        }

        System.out.println("hhhh");

    }

}
