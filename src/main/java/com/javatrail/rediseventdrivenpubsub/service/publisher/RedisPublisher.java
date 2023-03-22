package com.javatrail.rediseventdrivenpubsub.service.publisher;

import com.javatrail.rediseventdrivenpubsub.configs.RedisData;

public interface RedisPublisher {
    void publish(RedisData redisData);
}