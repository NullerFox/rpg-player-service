package com.nullerfox.playerservice.players.services;

import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    public String findAll() {
        return "players";
    }
}
