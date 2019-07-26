package java.com.apside.prono.test;

import org.junit.Before;
import static org.junit.Assert.assertEquals;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
public class PlayerPronoTest {

    private String mail1 = "player1@player.com";
    private String mail2 = "player2@player.com";
    // Player player = new Player(2L, "polo", "roger", "chiniolivier@yahoo.fr", new Date());

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void canGetAllPlayers() {
        /*List<Player> playerEntityList = new ArrayList<>();
        Player playerEntity = new Player();
        playerEntity.setId(1L);
        playerEntity.setMail(mail1);
        Player playerEntity2 = new Player();
        playerEntity2.setId(2L);
        playerEntity2.setMail(mail2);
        playerEntityList.add(playerEntity);
        playerEntityList.add(playerEntity2);
        when(playerRepository.findAll()).thenReturn(playerEntityList);
        List<Player> result = (List<Player>) playerService.getAllPlayers();
        assertEquals(2, result.size());*/
    }

    //Test getPlayerById

    @Test
    public void canGetPlayerById() {
       /* when(playerRepository.findById(2L)).thenReturn(Optional.of(player));
        assertNotNull(player); */
    }

    //Test modifyPlayer
    @Test
    public void updatePlayer() {
        /*Player playerEntity = new Player();
        playerEntity.setMail(mail1);
        playerEntity.setId(1L);
        Player playerUpdate = new Player();
        playerUpdate.setId(1L);
        playerUpdate.setMail(mail2);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(playerUpdate));
        Player player = playerService.modifyPlayer(playerUpdate);
        //assertEquals(Long.valueOf(1L), player.getId());
        assertEquals(mail2, player.getMail()); */
    }

    @Test
    public void savePlayer() {
        /*Player player = new Player();
        player.setMail(mail1);
        Player playerSave = new Player();
        playerSave.setId(1L);
        playerSave.setMail(mail1);
        when(playerRepository.save(player)).thenReturn(playerSave);
        Player player1 = playerService.createPlayer(player);
        assertEquals(Long.valueOf(1L), player.getId());
        assertEquals(mail1, player1.getMail()); */
    }

    @Test
    public void deletePlayer() {
       /* Player playerEntity = new Player();
        playerEntity.setId(1L);
        playerEntity.setMail(mail1);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(playerEntity));
        //playerService.deletePlayer(playerEntity); */
    }
}