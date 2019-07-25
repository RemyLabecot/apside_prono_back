package com.apside.prono.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apside.prono.model.Player;
import com.apside.prono.service.PlayerService;


@CrossOrigin
@RestController
@RequestMapping(value="/player")
public class PlayerRestController {

	@Autowired
	private PlayerService playerService;

	@GetMapping(produces = "application/json", path="/allplayers")
	public Iterable<Player> getAllPlayers() {

		return  playerService.getAllPlayers();
	}

	@PostMapping(consumes = "application/json", produces = "application/json", path="/newplayer")
	public Player create(@RequestBody Player player) {

		return playerService.createPlayer(player);
	}

	@GetMapping(produces = "application/json", path="/{id}")
	public Player getPlayerById(@PathVariable Long id) {
		return playerService.getPlayerById(id);
	}

	@PutMapping(consumes = "application/json", produces = "application/json", path="/modifyplayer")
	public Player modifyPlayer(@RequestBody Player player)  {
		return playerService.modifyPlayer(player);
	}
	
	@DeleteMapping(produces = "application/json", path="/deleteplayer")
	public void deletePlayer(@RequestBody Player player)  {
		playerService.deletePlayer(player);
	}
}

//fs.campus-cd.net