package com.nullerfox.playerservice;

import com.nullerfox.playerservice.players.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PlayerServiceApplicationTests {
	@Autowired
	private PlayerService playerService;

	@Test
	void contextLoads() {
		assertThat(playerService).isNotNull();
		assertThat(playerService.findAll()).isEqualTo("players");
	}
}
