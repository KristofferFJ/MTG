package Pairings.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "PLAYER")
@Table(name = "PLAYER", schema = "public")
public class Player implements Serializable{

    private static final long serialVersionUID = -3009157732242241630L;

    public Player(String playerName){
        this.playerName = playerName;
    }

    @Id
    @GeneratedValue
    @Column(name = "PLAYER_ID")
    private Long playerId;

    @Column(name = "PLAYER_NAME")
    private String playerName;

    @Column(name = "WINS")
    private int wins;

    @Column(name = "TIES")
    private int ties;

    @Column(name = "LOSSES")
    private int losses;

    @Column(name = "WIN_PERCENTAGE")
    private BigDecimal winPercentage;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tournament> tournaments;

    public String getPlayerName() {
        return playerName;
    }

    public long getTournamentWins(Tournament tournament){
        return tournament.getTournamentEvents().stream()
                .filter(event -> event.getMatchParticipants().contains(this))
                .filter(event -> event.getRoundWinner() == this)
                .count();
    }

    public long getTournamentTies(Tournament tournament){
        return tournament.getTournamentEvents().stream()
                .filter(event -> event.getMatchParticipants().contains(this))
                .filter(TournamentEvent::isTiedMatch)
                .count();
    }

    public int getPoints(Tournament tournament) {
        return this.wins * 3 + this.ties;
    }

    public long getRoundsPlayed(Tournament tournament){
         return tournament.getTournamentEvents().stream()
                .filter(event -> event.getMatchParticipants().contains(this))
                .count();
    }
}
