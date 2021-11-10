package com.nullerfox.playerservice.player.service;

import com.nullerfox.playerservice.player.entity.Player;
import com.nullerfox.playerservice.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    
    public PlayerService(@Autowired final PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    
    public List<Player> findAll() {
        return this.playerRepository.findAll();
    }
    
    public Optional<Player> find(final String id) {
        return this.playerRepository.findById(id);
    }
    
    public Player save(final Player player) {
        return this.playerRepository.save(player);
    }
}
