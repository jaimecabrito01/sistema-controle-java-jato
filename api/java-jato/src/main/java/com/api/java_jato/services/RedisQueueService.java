package com.api.java_jato.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class RedisQueueService {
    private static final String ACTIVE_QUEUE_KEY = "carwash:active:services";

    @Autowired
    private final ReactiveRedisTemplate<String, Long> reactiveRedisTemplate;

    public RedisQueueService(ReactiveRedisTemplate<String, Long> reactiveRedisTemplate) {
        this.reactiveRedisTemplate = reactiveRedisTemplate;
    }

    public Mono<Boolean> addActiveQueue(Long id) {
        double score = Instant.now().toEpochMilli();
        return reactiveRedisTemplate.opsForZSet()
                .add(ACTIVE_QUEUE_KEY, id, score)
                .doOnSuccess(added -> {
                    if (added) {
                        System.out
                                .println("ID do Serviço " + id + " adicionado à fila ativa. Score (Entrada): " + score);
                    }
                });

    }
    

}
