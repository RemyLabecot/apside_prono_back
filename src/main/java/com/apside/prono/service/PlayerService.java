package com.apside.prono.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apside.prono.errors.PlayerInconnuException;
import com.apside.prono.model.Player;
import com.apside.prono.repository.PlayerRepository;


@Service
public class PlayerService {

	@Autowired
	private PlayerRepository  playerRepository;

	
	public Iterable <Player> getAllPlayers () {
		return playerRepository.findAll();
	}
	
	@Transactional
	public Player createPlayer(Player player) {
		return playerRepository.save(player);
	}
	
	public Player getPlayerById(Long id) throws PlayerInconnuException {
		Player player = playerRepository.findById(id).get();
		if(player==null) {
			throw new PlayerInconnuException(id);
		}
		return player;
	}
	
	@Transactional
	public Player modifyPlayer(Player player) throws PlayerInconnuException {
		Player playerModif = getPlayerById(player.getId());

		playerModif.setId(player.getId());
		playerModif.setFirstName(player.getFirstName());
		playerModif.setLastName(player.getLastName());
		playerModif.setMail(player.getMail());
		playerModif.setSubscriptionDate(player.getSubscriptionDate());
		
		return playerModif;
	}
	
	@Transactional
	public void deletePlayer(Player player) {
		playerRepository.delete(player);
	}
}
