package com.pks.cricket_app.services;

import com.pks.cricket_app.dtos.PlayerRequest;
import com.pks.cricket_app.dtos.PlayerResponse;

import java.util.List;

public interface PlayerService {
    PlayerResponse addPlayer(PlayerRequest playerRequest);


    List<PlayerResponse> getAllPlayers();

    PlayerResponse getPlayerById(Integer id);

    String deletePlayer(Integer playerId);

    List<PlayerResponse> searchForPlayerWithRole(String role);
}
