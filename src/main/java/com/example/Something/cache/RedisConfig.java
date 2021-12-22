package com.example.Something.cache;

import java.time.Duration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
@EnableCaching
public class RedisConfig {

	@Bean
	public RedisCacheConfiguration redisCacheConfiguration() {
		return RedisCacheConfiguration.defaultCacheConfig()
				.computePrefixWith(name -> name + ":") // cache key : value 로 나오도록
				.entryTtl(Duration.ofSeconds(10)) // TTL
				.serializeValuesWith(SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())); // JSON으로 직렬화
	}
}
