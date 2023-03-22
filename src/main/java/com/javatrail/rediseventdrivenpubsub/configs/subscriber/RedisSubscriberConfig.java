package com.javatrail.rediseventdrivenpubsub.configs.subscriber;

import com.javatrail.rediseventdrivenpubsub.service.subscriber.RedisMessageSubscriber;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@AllArgsConstructor
public class RedisSubscriberConfig {

    private final RedisMessageSubscriber consumer;
    private final ChannelTopic topic;

    @Bean
    RedisMessageListenerContainer redisContainer(JedisConnectionFactory jedisConnectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory);
        container.setTopicSerializer(RedisSerializer.string());
        container.addMessageListener(consumer, topic); //when message is published into message broker the "RedisMessageSubscriber consumer" will be invoked and will listen for message on "topic"
        return container;
    }
}