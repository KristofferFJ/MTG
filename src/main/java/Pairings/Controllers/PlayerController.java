package Pairings.Controllers;

import Pairings.Entities.Player;
import Pairings.Entities.PlayerRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    @RequestMapping(path = "addPlayer", method = RequestMethod.POST)
    public List<Player> addPlayer(String[] name){
        List<Player> newPlayers = new ArrayList<>();

        for(String person : name) {
            Player newPlayer = new Player(person);
            playerRepository.save(newPlayer);
            newPlayers.add(newPlayer);
        }
        return newPlayers;
    }
}
