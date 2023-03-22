package com.javatrail.rediseventdrivenpubsub.configs.publisher;

import com.javatrail.rediseventdrivenpubsub.configs.RedisData;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@Configuration
public class RedisPublisherConfig {

    @Bean
    ChannelTopic getTopic() {
        return new ChannelTopic("mq-chat");
    }

    @Bean
    RedisTemplate<String, Object> redisMessagingTemplate(JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        template.setConnectionFactory(jedisConnectionFactory);
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(RedisData.class));
        return template;
    }

}