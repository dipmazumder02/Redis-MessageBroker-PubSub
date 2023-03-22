package com.javatrail.rediseventdrivenpubsub.service.publisher.impl;
import com.javatrail.rediseventdrivenpubsub.configs.RedisData;
import com.javatrail.rediseventdrivenpubsub.service.publisher.RedisPublisher;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class RedisPublisherImpl implements RedisPublisher {

    private final RedisTemplate<String, Object> redisTemplate;
    private final ChannelTopic channelTopic;
    /*this channel topic will be used to publish and subscribe to this topic*/
    @Override
     public void publish(RedisData redisData) {
        log.info("Publishing message on Redis channel {} with content: {}", channelTopic.getTopic(), redisData);
        redisTemplate.convertAndSend(channelTopic.getTopic(), redisData);
    }

}