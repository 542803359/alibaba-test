package com.xiaowenxing.mq;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author XWX
 * @date 2021/9/10 16:21
 * @since 4.2
 **/
@Configuration
@EnableBinding({RocketMqConfig.MySink.class})
public class RocketMqConfig {

    public final static String STREAM_BINDING_ROCKET_TEST_INPUT_CHANNEL = "rocketInputTestChannel";

    public final static String STREAM_BINDING_ROCKET_VIDEO_INPUT_CHANNEL = "rocketInputVideoChannel";

    public final static String STREAM_BINDING_ROCKET_VIDEO_INPUT_CHANNEL2 = "rocketInputVideoChannel2";

    public interface MySink {
        @Input(RocketMqConfig.STREAM_BINDING_ROCKET_TEST_INPUT_CHANNEL)
        SubscribableChannel rocketInputTestChannel();

        @Input(RocketMqConfig.STREAM_BINDING_ROCKET_VIDEO_INPUT_CHANNEL)
        SubscribableChannel rocketInputVideoChannel();

        @Input(RocketMqConfig.STREAM_BINDING_ROCKET_VIDEO_INPUT_CHANNEL2)
        SubscribableChannel rocketInputVideoChannel2();
    }
}
