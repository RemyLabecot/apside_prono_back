package com.apside.prono.test;

import org.junit.Before;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apside.prono.model.Player;
import com.apside.prono.repository.PlayerRepository;
import com.apside.prono.service.PlayerService;
import static org.mockito.Mockito.*;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)

public class PlayerPronoTest {
	Player player = new Player(2L, "polo", "roger", "chiniolivier@yahoo.fr", new Date());
	
	@Mock
	private PlayerRepository playerRepository;
	
	@InjectMocks
	private PlayerService playerService;
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void canGetPlayerById() {
		
		when(playerService.getPlayerById(2L)).thenReturn(player);
		
		assertNotNull(player);
		}
	} 