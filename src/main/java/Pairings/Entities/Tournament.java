package Pairings.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tournament")
@Table(name = "Tournament", schema = "public")
public class Tournament implements Serializable {

    private static final long serialVersionUID = -3009157732242241621L;

    public Tournament(String tournamentName, List<Player> tournamentPlayers){
        this.tournamentName = tournamentName;
        this.tournamentPlayers = tournamentPlayers;
    }

    @Id
    @GeneratedValue
    @Column(name = "TOURNAMENT_ID")
    private Long tournamentId;

    @Column(name = "TOURNAMENT_NAME")
    private String tournamentName;

    @OneToOne
    @JoinColumn(name = "WINNER", referencedColumnName = "PLAYER_ID")
    private Player player;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Player> tournamentPlayers = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TournamentEvent> tournamentEvents = new ArrayList<>();

    public void addTournamentEvent(TournamentEvent tournamentEvent){
        tournamentEvents.add(tournamentEvent);
    }

    public Long getTournamentId(){
        return tournamentId;
    }

    public List<Player> getTournamentPlayers(){
        return tournamentPlayers;
    }

    public List<TournamentEvent> getTournamentEvents(){
        return tournamentEvents;
    }

    public String getTournamentName(){ return tournamentName; }

    @Override
    public String toString() {
        return ("%s, name");
    }
}