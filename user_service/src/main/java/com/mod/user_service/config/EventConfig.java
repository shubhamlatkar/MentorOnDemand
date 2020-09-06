package com.mod.user_service.config;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface EventConfig {
    @Input
    public SubscribableChannel ModAuth();
}
