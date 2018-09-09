package Pairings;

import Pairings.Entities.Player;
import Pairings.Entities.PlayerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes={Application.class})
public class AddPlayerTest {

    //@Autowired
    PlayerRepository playerRepository;

    //@Test
    public void addPlayersToDatabase() {
        playerRepository.deleteAll();

        Player Kris = new Player("KristofferFJ");
        Player Ole = new Player("Madmanole");
        Player Kristian = new Player("Meatstone");
        Player BG = new Player("Zerg");

        playerRepository.save(Kris);
        playerRepository.save(Ole);
        playerRepository.save(Kristian);
        playerRepository.save(BG);
    }

}