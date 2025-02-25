package com.buildingblocks.challenges.infra.mainservice.config;

import com.buildingblocks.challenges.application.player.createplayer.CreatePlayerUseCase;
import com.buildingblocks.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreatePlayerUseCase createPlayerUseCase(MongoAdapter mongoAdapter) {
        return new CreatePlayerUseCase(mongoAdapter);
    }
}
