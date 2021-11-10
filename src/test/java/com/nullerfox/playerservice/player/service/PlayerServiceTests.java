package com.nullerfox.playerservice.player.service;

import com.nullerfox.hellpers.databases.mongo.EnableMongoTestServer;
import com.nullerfox.playerservice.player.entity.Player;
import com.nullerfox.playerservice.player.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EnableMongoTestServer
@EnableMongoRepositories(basePackageClasses = {
        PlayerRepository.class
})
class PlayerServiceTests {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepository playerRepository;
    
    @BeforeEach
    void setup() {
        assertThat(playerService).isNotNull();
        assertThat(playerRepository).isNotNull();
        playerRepository.deleteAll();
    }
    
    @Test
    void shouldCreateAPlayer() {
        final var player = new Player();
        player.setName("Player One");
        
        final var saved = playerService.save(player);
        assertThat(saved).isNotNull();
        assertThat(saved.getName()).isEqualTo("Player One");
    }
    
    @Test
    void shouldNotFindAnyPlayer() {
        assertThat(playerService.findAll()).isEmpty();
    }
    
    @Test
    void shouldFindManyPlayer() {
        assertThat(playerService.findAll()).isEmpty();
        
        for (int i = 0; i < 10; i++) {
            final var player = new Player();
            player.setName("Player " + i);
            playerService.save(player);
        }
        
        assertThat(playerService.findAll()).hasSize(10);
    }
    
    @Test
    void shouldNotFindAPlayer() {
        assertThat(playerService.find("any")).isEmpty();
    }
    
    @Test
    void shouldFindAPlayer() {
        final var player = new Player();
        player.setName("Player One");
        final var saved = playerService.save(player);
        
        assertThat(playerService.find(saved.getId())).isNotEmpty().contains(saved);
    }
}
