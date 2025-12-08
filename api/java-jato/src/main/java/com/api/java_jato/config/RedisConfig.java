package com.api.java_jato.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    @Bean
    public ReactiveRedisTemplate<String, Long> reactiveRedisTemplate(ReactiveRedisConnectionFactory factory) {
        
        // Serializador para a chave (String)
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        
        // Serializador para o valor (Long - o ID do serviço)
        // Usamos Jackson para serializar o Long de forma robusta
        Jackson2JsonRedisSerializer<Long> valueSerializer = 
            new Jackson2JsonRedisSerializer<>(Long.class);

        // Constrói o contexto de serialização
        RedisSerializationContext<String, Long> context = 
            RedisSerializationContext.<String, Long>newSerializationContext(keySerializer)
            .value(valueSerializer)
            .build();

        // Cria e retorna o Template Reativo
        return new ReactiveRedisTemplate<>(factory, context);
    }
    
}
