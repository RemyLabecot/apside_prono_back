package com.apside.prono.service;

import com.apside.prono.errors.InvalidPlayerDataException;
import com.apside.prono.errors.PlayerUnknownException;
import com.apside.prono.model.Player;
import com.apside.prono.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public Iterable<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Transactional
    public void createPlayer(Player player) {
        if (player.getFirstName() == null || player.getLastName() == null
                || player.getMail() == null || player.getSubscriptionDate() == null) {
            throw new InvalidPlayerDataException();
        } else {
            playerRepository.save(player);
        }
    }

    public Player getPlayerById(Long id) throws PlayerUnknownException {

        return playerRepository.findById(id).get();
    }

    @Transactional
    public void deletePlayer(Long id) {
        if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
        } else {
            throw new InvalidPlayerDataException();
        }
    }

    @Transactional
    public Player updatePlayer(Player player) {

        if (player.getFirstName() == null || player.getLastName() == null || player.getMail() == null || player.getSubscriptionDate() == null) {
            throw new InvalidPlayerDataException();
        } else {
            Player playerUpdate = new Player();
            if (playerRepository.existsById(player.getId())) {
                playerUpdate = playerRepository.save(player);
            }
            return playerUpdate;
        }
    }
}
