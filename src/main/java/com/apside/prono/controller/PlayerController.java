package com.apside.prono.controller;


import com.apside.prono.errors.PlayerUnknownException;
import com.apside.prono.model.Player;
import com.apside.prono.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;


@CrossOrigin
@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(produces = "application/json", path = "/player/allPlayers")
    public Iterable<Player> getAllPlayers() {

        return playerService.getAllPlayers();
    }

    @GetMapping(produces = "application/json", path = "/player/{id}")
    public Player getPlayerById(@PathVariable Long id) throws PlayerUnknownException {
        Player findPlayer = new Player();
        try {
            findPlayer = playerService.getPlayerById(id);
        } catch (PlayerUnknownException e) {
            e.getMessage();
        }
        return findPlayer;
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/player/create")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player, UriComponentsBuilder uriBuilder) {
        playerService.createPlayer(player);
        URI location = uriBuilder.path("/player/{id}").buildAndExpand(player.getId()).toUri();
        return ResponseEntity.created(location).body(player);
    }

    @PutMapping(consumes = "application/json", produces = "application/json", path = "/player/update")
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

    @DeleteMapping(path = "/player/delete/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
