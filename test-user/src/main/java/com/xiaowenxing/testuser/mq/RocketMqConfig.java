package com.xiaowenxing.testuser.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.MessageChannel;

/**
 * @author XWX
 * @date 2021/9/10 10:40
 * @since 4.2
 **/
@Configuration
@EnableBinding({RocketMqConfig.MySource.class})
public class RocketMqConfig {

    public final static String STREAM_BINDING_ROCKET_TEST_OUTPUT_CHANNEL = "rocketOutputTestChannel";

    public final static String STREAM_BINDING_ROCKET_VIDEO_OUTPUT_CHANNEL = "rocketOutputVideoChannel";


    public interface MySource {

        @Output(RocketMqConfig.STREAM_BINDING_ROCKET_TEST_OUTPUT_CHANNEL)
        MessageChannel rocketOutputTestChannel();

        @Output(RocketMqConfig.STREAM_BINDING_ROCKET_VIDEO_OUTPUT_CHANNEL)
        MessageChannel rocketOutputVideoChannel();
    }
}
