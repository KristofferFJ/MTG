package Pairings.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tournament_event")
@Table(name = "TournamentEvent", schema = "public")
public class TournamentEvent implements Serializable {

    private static final long serialVersionUID = -3009157732242241605L;

    public TournamentEvent(Tournament tournament) {
        this.tournamentId = tournament.getTournamentId();

        tournament.addTournamentEvent(this);
    }

    @Id
    @GeneratedValue
    @Column(name = "TOURNAMENT_EVENT_ID")
    private Long tournamentEventId;

    @Column(name = "TOURNAMENT_ID")
    private Long tournamentId;

    @OneToOne
    @JoinColumn(name = "PLAYER_ONE", referencedColumnName = "PLAYER_ID")
    private Player playerOne;

    @OneToOne
    @JoinColumn(name = "PLAYER_TWO", referencedColumnName = "PLAYER_ID")
    private Player playerTwo;

    @Column(name = "PLAYER_ONE_ROUNDS")
    private int playerOneRounds;

    @Column(name = "PLAYER_TWO_ROUNDS")
    private int playerTwoRounds;

    public Long getTournamentId() {
        return tournamentId;
    }

    public Long getTournamentEventId() {
        return tournamentEventId;
    }

    public boolean isTiedMatch() {
        return playerOneRounds == playerTwoRounds;
    }

    public Player getRoundWinner(){
        if (playerOneRounds == playerTwoRounds){
            return null;
        }
        return playerOneRounds > playerTwoRounds ? playerOne : playerTwo;
    }

    public void setPlayerOneRounds(int playerOneRounds) {
        this.playerOneRounds = playerOneRounds;
    }

    public void setPlayerTwoRounds(int playerTwoRounds) {
        this.playerTwoRounds = playerTwoRounds;
    }

    public List<Player> getMatchParticipants(){
        List<Player> players = new ArrayList<>();
        players.add(playerOne);
        players.add(playerTwo);

        return players;
    }
}