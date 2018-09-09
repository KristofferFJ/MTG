package Pairings.Controllers;

import Pairings.Entities.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TournamentController {

    private final TournamentRepository tournamentRepository;
    private final TournamentEventRepository tournamentEventRepository;
    private final PlayerRepository playerRepository;

    public TournamentController(TournamentRepository tournamentRepository,
                                TournamentEventRepository tournamentEventRepository,
                                PlayerRepository playerRepository){
        this.tournamentRepository = tournamentRepository;
        this.tournamentEventRepository = tournamentEventRepository;
        this.playerRepository = playerRepository;
    }

    @RequestMapping(path = "newTournament", method = RequestMethod.POST)
    public Tournament startNewTournament(String tournamentName, List<Player> players){
        Tournament tournament = new Tournament(tournamentName, players);
        tournamentRepository.save(tournament);

        for(Player player : players){
            Player tournamentAttendant = playerRepository.findByPlayerName(player.getPlayerName());
            if (tournamentAttendant == null){
                tournamentAttendant = new Player(player.getPlayerName());
                playerRepository.save(tournamentAttendant);
            }
            TournamentEvent tournamentEvent = new TournamentEvent(tournament);
            tournamentEventRepository.save(tournamentEvent);
        }

        return tournament;
    }
}
