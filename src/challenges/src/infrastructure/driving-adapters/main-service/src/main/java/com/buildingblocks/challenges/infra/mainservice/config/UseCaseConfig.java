package com.buildingblocks.challenges.infra.mainservice.config;

import com.buildingblocks.challenges.application.card.activecard.ActiveCardUseCase;
import com.buildingblocks.challenges.application.card.desactivecard.DesactiveCardUseCase;
import com.buildingblocks.challenges.application.player.createplayer.CreatePlayerUseCase;
import com.buildingblocks.challenges.application.player.drawcard.DrawCardUseCase;
import com.buildingblocks.challenges.application.player.playcard.PlayCardUseCase;
import com.buildingblocks.infra.mongo.adapters.MongoAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Bean
    public CreatePlayerUseCase createPlayerUseCase(MongoAdapter mongoAdapter) {
        return new CreatePlayerUseCase(mongoAdapter);
    }

    @Bean
    public DesactiveCardUseCase desactiveCardUseCase(MongoAdapter mongoAdapter) {
        return new DesactiveCardUseCase(mongoAdapter);
    }

    @Bean
    public PlayCardUseCase playCardUseCase(MongoAdapter mongoAdapter) {
        return new PlayCardUseCase(mongoAdapter);
    }

    @Bean
    public DrawCardUseCase drawCardUseCase(MongoAdapter mongoAdapter) {
        return new DrawCardUseCase(mongoAdapter);
    }

    @Bean
    public ActiveCardUseCase activeCardUseCase(MongoAdapter mongoAdapter) {
        return new ActiveCardUseCase(mongoAdapter);
    }

}
