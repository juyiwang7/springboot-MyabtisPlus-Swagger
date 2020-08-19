package com.example.bootMp.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;


@Configuration
public class StringRedisKeyConfig {
    @Bean(name = "stringRedisKeyDatabase")
    public RedisTemplate<String, String> redisTemplate(
            @Value("${user-redis.host}")String hostName,
            @Value("${user-redis.port}")int port,
            @Value("${user-redis.password}")String password,
            @Value("${user-redis.pool.max-idle}")int maxIdle,
            @Value("${user-redis.pool.max-active}")int maxTotal,
            @Value("${user-redis.database}")int index,
            @Value("${user-redis.pool.max-wait}")long maxWaitMillis) {
        //设置序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        RedisTemplate<String, String> temple = new RedisTemplate<String, String>();
        temple.setConnectionFactory(this.connectionFactory(
                hostName, port, password, maxIdle, maxTotal, index, maxWaitMillis));

        temple.setDefaultSerializer(new StringRedisSerializer());
        temple.setKeySerializer(new StringRedisSerializer());
        temple.setHashKeySerializer(new StringRedisSerializer());
        temple.setHashValueSerializer(new StringRedisSerializer());
        temple.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return temple;
    }

    public RedisConnectionFactory connectionFactory(
            String hostName, int port, String password, int maxIdle,int maxTotal, int index, long maxWaitMillis) {
        JedisConnectionFactory jedis = new JedisConnectionFactory();
        jedis.setHostName(hostName);
        jedis.setPort(port);
        jedis.setPassword(password);
        jedis.setDatabase(index);
        jedis.setPoolConfig(this.poolCofig(maxIdle, maxTotal, maxWaitMillis));
        // 初始化连接pool
        jedis.afterPropertiesSet();
        RedisConnectionFactory factory = jedis;
        return factory;
    }

    public JedisPoolConfig poolCofig(int maxIdle, int maxTotal, long maxWaitMillis) {
        JedisPoolConfig poolCofig = new JedisPoolConfig();
        poolCofig.setMaxIdle(maxIdle);
        poolCofig.setMaxTotal(maxTotal);
        poolCofig.setMaxWaitMillis(maxWaitMillis);
        poolCofig.setTestOnBorrow(false);
        return poolCofig;
    }
}



