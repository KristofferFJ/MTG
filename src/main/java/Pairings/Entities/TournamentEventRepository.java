package Pairings.Entities;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TournamentEventRepository extends CrudRepository<TournamentEvent, Long> {

    TournamentEvent findByTournamentEventId(Long tournamentEventId);
    List<TournamentEvent> findAllByTournamentId(Long tournamentId);

}