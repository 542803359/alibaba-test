package com.xiaowenxing.testuser.controller;


import com.xiaowenxing.testuser.mq.RocketMqConfig;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * 测试
 *
 * @author XWX
 * @date 2021/9/7 13:54
 * @since 4.1
 **/
@RestController
@RequestMapping("/nacos/config")
// 注解方式读取配置，如果需要动态更新，需要加上此注解
@RefreshScope
public class TestController {


    /**
     * 在 Nacos Spring Cloud 中，dataId 的完整格式如下：
     * <p>
     * ${prefix}-${spring.profiles.active}.${file-extension}
     * <p>
     * prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。
     * <p>
     * spring.profiles.active 即为当前环境对应的 profile，详情可以参考 Spring Boot文档。
     * 注意：当 spring.profiles.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 ${prefix}.${file-extension}
     * <p>
     * file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。
     * 目前只支持 properties 和 yaml 类型。
     */

    @Value("${spring.cloud.stream.rocketmq.binder.access-key:111}")
    private String gender;


    @RequestMapping("/test")
    public String test2() {
        return gender;
    }

    @Autowired
    private RocketMqConfig.MySource mySource;


    @GetMapping("/mqTest")
    public String mqTest(@RequestParam String msg) {

        boolean send = mySource.rocketOutputTestChannel().send(MessageBuilder.withPayload(msg).build());
        return msg + "---" + send;
    }


    @GetMapping("/videoTest")
    public String videoTest(@RequestParam String videoName) {

        boolean send = mySource.rocketOutputVideoChannel().send(MessageBuilder.withPayload(videoName).build());
        return videoName + "---" + send;

    }

    /**
     * 下面两个方法演示同一个topic,不同tag发送,在消费者yml中设置不同的tag进行消息过滤
     */

    @GetMapping("/videoTestForKey")
    public String videoTestForKey(@RequestParam String videoName) {

        Message<String> message = MessageBuilder.withPayload(videoName)
                .setHeader(RocketMQHeaders.TAGS, "test-tag")
                .setHeader(RocketMQHeaders.KEYS, UUID.randomUUID().toString()).build();
        boolean send = mySource.rocketOutputVideoChannel().send(message);
        return videoName + "---" + send;

    }

    @GetMapping("/videoTestForKey2")
    public String videoTestForKey2(@RequestParam String videoName) {

        Message<String> message = MessageBuilder.withPayload(videoName)
                .setHeader(RocketMQHeaders.TAGS, "test-tag-demo")
                .setHeader(RocketMQHeaders.KEYS, UUID.randomUUID().toString()).build();
        boolean send = mySource.rocketOutputVideoChannel().send(message);
        return videoName + "---" + send;

    }
}
