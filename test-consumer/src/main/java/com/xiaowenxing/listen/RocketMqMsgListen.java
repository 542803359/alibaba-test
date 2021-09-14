package com.xiaowenxing.listen;

import com.xiaowenxing.mq.RocketMqConfig;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * @author XWX
 * @date 2021/9/10 16:29
 * @since 4.2
 **/
@Service
public class RocketMqMsgListen {

    @StreamListener(value = RocketMqConfig.STREAM_BINDING_ROCKET_TEST_INPUT_CHANNEL)
    public void receiveInput1(String receiveMsg) {
        System.out.println("rocketInputTestChannel receive: " + receiveMsg);
    }


    @StreamListener(value = RocketMqConfig.STREAM_BINDING_ROCKET_VIDEO_INPUT_CHANNEL)
    public void receiveInput2(Message<String> message) {
        System.out.println("rocketInputVideoChannel Payload: " + message.getPayload());
        System.out.println("rocketInputVideoChannel Headers: "+message.getHeaders().toString());
    }


    @StreamListener(value = RocketMqConfig.STREAM_BINDING_ROCKET_VIDEO_INPUT_CHANNEL2)
    public void receiveInput3(Message<String> message) {
        System.out.println("rocketInputVideoChannel Payload: " + message.getPayload());
        System.out.println("rocketInputVideoChannel Headers: "+message.getHeaders().toString());
    }
}
