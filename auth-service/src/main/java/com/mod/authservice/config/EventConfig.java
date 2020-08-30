package com.mod.authservice.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventConfig {
    @Output
    public MessageChannel ModAuth();
}
