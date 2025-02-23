package com.buildingblocks.challenges.application.shared;

import com.buildingblocks.challenges.domain.player.Player;

public class PlayerMapper {

    public static PlayerResponse toResponse(Player player) {
        return new PlayerResponse(
                player.getIdentity().getValue(),
                player.getNickName().getValue()
        );
    }
}
