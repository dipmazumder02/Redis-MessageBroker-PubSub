package com.javatrail.rediseventdrivenpubsub.service.subscriber;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class RedisMessageSubscriber implements MessageListener {
    public static List<String> messages = new ArrayList<>();
    /*whenever a message is published to a redis server, this onMessage method will be invoked,
     on that particular event what needed to be done
    * those tasks will be performed inside on message method*/
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String receivedMessage = new String(message.getBody());
        messages.add(message.toString());
        log.info("Message Received : {}", receivedMessage);
    }

}