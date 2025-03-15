package com.pks.cricket_app.controller;


import com.pks.cricket_app.dtos.PlayerRequest;
import com.pks.cricket_app.dtos.PlayerResponse;
import com.pks.cricket_app.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")

public class PlayerController {

    @Autowired
    private PlayerService playerService;

    private static final Logger log = LoggerFactory.getLogger(PlayerController.class);

    @PostMapping
    public ResponseEntity<PlayerResponse> addPlayer(@RequestBody PlayerRequest playerRequest) {
        log.info("Starting in the add player controller");

        PlayerResponse playerResponse =
                playerService.addPlayer(playerRequest);
        log.info("Ending in the add player controller");
        return new ResponseEntity<>(playerResponse, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        log.info("Inside getAllPlayers");
        List<PlayerResponse> allPlayers = playerService.getAllPlayers();
        return new ResponseEntity<>(allPlayers, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerResponse>
    getPlayerBYId(@PathVariable("id") Integer id) {
        PlayerResponse playerResponse =
                playerService.getPlayerById(id);

        return new ResponseEntity<>(playerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>
    deletePlayer(@PathVariable("id") Integer playerId){
       String message
                = playerService.deletePlayer(playerId);
        return new ResponseEntity<>(message , HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PlayerResponse>> searchPlayer(
            @RequestParam("role") String role
    ){
        List<PlayerResponse> players = playerService
                .searchForPlayerWithRole(role);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }
}