package Pairings.Entities;

import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Player findByPlayerName(String playerName);

}