package Pairings.Controllers;

import Pairings.Entities.Player;
import Pairings.Entities.Tournament;
import Pairings.Entities.TournamentEvent;
import Pairings.Entities.TournamentEventRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
public class TournamentEventController {

    private final TournamentEventRepository tournamentEventRepository;

    public TournamentEventController(TournamentEventRepository tournamentEventRepository){
        this.tournamentEventRepository = tournamentEventRepository;
    }

    @RequestMapping(path = "reportRoundResults", method = RequestMethod.POST)
    public void reportRoundResult(Long tournamentEventId, int playerOneRounds, int playerTwoRounds){
        TournamentEvent tournamentEvent = tournamentEventRepository.findByTournamentEventId(tournamentEventId);

        tournamentEvent.setPlayerOneRounds(playerOneRounds);
        tournamentEvent.setPlayerTwoRounds(playerTwoRounds);

        tournamentEventRepository.save(tournamentEvent);
    }

    @RequestMapping(path = "getNextRound", method = RequestMethod.POST)
    public void getNextRound(Long tournamentId){
    }

    private List<List<Long>> getPairingsInformation(Tournament tournament){
        if(!validateReadyForPairing(tournament)){
            throw new IllegalArgumentException("Players haven't played the same number of rounds");
        }

        List<TournamentEvent> tournamentEvents = tournament.getTournamentEvents();



        return null;
    }

    private Boolean validateReadyForPairing(Tournament tournament){
        List<Player> players = tournament.getTournamentPlayers();

        return players.stream().allMatch(player -> player.getRoundsPlayed(tournament) == players.get(0).getRoundsPlayed(tournament));
    }

    private List<TournamentEvent> createTournamentEvents(Tournament tournament, List<Player> unpairedPlayers, List<TournamentEvent> tournamentEvents){
        long maxPoints = getMaxPoints(unpairedPlayers, tournament);
        if(unpairedPlayers.stream().filter(player -> (player.getPoints(tournament) == maxPoints)).count() % 2 == 0){

        }

        return null;
    }

    private List<TournamentEvent> prepareMatches(List<Player> players, Tournament tournament){
        //PairingController med mål for dårlighed?
        return null;
    }

    private long getMaxPoints(List<Player> players, Tournament tournament){
        long maxPoints = 0;
        for (Player player : players){
            long playerPoints = player.getPoints(tournament);
            maxPoints = (playerPoints > maxPoints ? playerPoints : maxPoints);
        }
        return maxPoints;
    }

}
