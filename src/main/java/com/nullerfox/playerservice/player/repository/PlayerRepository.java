package com.nullerfox.playerservice.player.repository;

import com.nullerfox.playerservice.player.entity.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface PlayerRepository extends MongoRepository<Player, String> {
}
