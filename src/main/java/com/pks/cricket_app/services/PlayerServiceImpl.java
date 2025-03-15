package com.pks.cricket_app.services;

import com.pks.cricket_app.controller.PlayerController;
import com.pks.cricket_app.dtos.PlayerRequest;
import com.pks.cricket_app.dtos.PlayerResponse;
import com.pks.cricket_app.entity.Player;
import com.pks.cricket_app.exception.CricketAppCustomException;
import com.pks.cricket_app.repository.PlayerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @Override
    public PlayerResponse addPlayer(PlayerRequest playerRequest) {
        log.info("Starting in the add player service");
        Player player = new Player();
        BeanUtils.copyProperties(playerRequest,player);
        System.out.println(player);
        final Player savedPlayer = playerRepository.save(player);
        System.out.println("Saved Player"+ savedPlayer);
        PlayerResponse playerResponse = new PlayerResponse();
        BeanUtils.copyProperties(savedPlayer,playerResponse);
        log.info("Ending in the add player service");
        return playerResponse;
    }

    @Override
    public List<PlayerResponse> getAllPlayers() {
        log.info("Inside getAllPlayers Service");

        final List<Player> allPlayers = playerRepository.findAll();
        final List<PlayerResponse> playerResponses =
                allPlayers.stream()
                .map(player -> {
                    PlayerResponse response
                            = new PlayerResponse();
                    BeanUtils.copyProperties(player, response);
                    return response;
                }).collect(Collectors.toList());
        return playerResponses;
    }

    @Override
    public PlayerResponse getPlayerById(Integer id) {
        PlayerResponse playerResponse
                =new PlayerResponse();

            Player player=  playerRepository.findById(id)
                        .orElseThrow(
                                ()->new CricketAppCustomException("Player with Id "+id
                                        +" not found","PLAYER_NOT_FOUND"));
                BeanUtils.copyProperties(player,playerResponse);

        return playerResponse;
    }

    @Override
    public String deletePlayer(Integer playerId) {
        Player player=  playerRepository.findById(playerId)
                .orElseThrow(
                        ()->new CricketAppCustomException("Player with Id "+playerId
                                +" not found","PLAYER_NOT_FOUND"));
        playerRepository.deleteById(player.getPlayerId());

        return String.format("player with the id %s is deleted successfully",playerId);
    }


}
