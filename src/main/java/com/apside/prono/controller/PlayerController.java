package com.apside.prono.controller;


import com.apside.prono.errors.PlayerUnknownException;
import com.apside.prono.model.Player;
import com.apside.prono.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping(produces = "application/json", path = "/allPlayers")
    public Iterable<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping(produces = "application/json", path = "/{id}")
    public Player getPlayerById(@PathVariable Long id) throws PlayerUnknownException {
        Player findPlayer = new Player();
        try {
            findPlayer = playerService.getPlayerById(id);
        } catch(PlayerUnknownException e) {
            e.getMessage();
        }
        return findPlayer;
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/create")
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer(player);
    }

    @PutMapping(consumes = "application/json", produces = "application/json", path = "/update")
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.updatePlayer(player);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
    }
}
