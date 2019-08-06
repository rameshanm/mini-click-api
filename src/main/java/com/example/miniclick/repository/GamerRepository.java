package com.example.miniclick.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Tuple;

import com.example.miniclick.model.Gamer;
import com.example.miniclick.model.vm.AvgScoreView;
import com.example.miniclick.model.vm.ScoreView;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

// @RepositoryRestResource(collectionResourceRel = "users", path = "users")
@Repository
public interface GamerRepository extends JpaRepository<Gamer, Long> {

    Optional<List<Gamer>> findAllByGame(String game);

    @Query(value = "select max(score) from gamer where game = 'A'", nativeQuery = true)
    int getHighestScoreByGame(String game);

    @Query(value = "select avg(score) from gamer where game = :game", nativeQuery = true)
    Double getAvgScoreByGame(@Param("game") String game);

    @Query(value = "SELECT game, min(score) as score FROM GAMER GROUP BY game", nativeQuery = true)
    List<ScoreView> getMinScoreOfAllGame();

    @Query(value = "SELECT game, max(score) as score FROM GAMER GROUP BY game", nativeQuery = true)
    List<ScoreView> getMaxScoreOfAllGame();

    @Query(value = "SELECT game, avg(score) as score FROM GAMER GROUP BY game", nativeQuery = true)
    List<ScoreView> getAvgScoreOfAllGame();

    @Query(value = "SELECT game, count(user_name) as count FROM GAMER GROUP BY game", nativeQuery = true)
    List<Tuple> getUserCountOfAllGame();

    @Query(value = "SELECT difficulty, game, min(score) as score FROM GAMER GROUP BY game, difficulty", nativeQuery = true)
    List<Tuple> getMinScoreByGameAndDifficulty();

    @Query(value = "SELECT difficulty, game, max(score) FROM GAMER GROUP BY game, difficulty", nativeQuery = true)
    List<Tuple> getMaxScoreByGameAndDifficulty();

    @Query(value = "SELECT game, difficulty, avg(score) FROM GAMER GROUP BY game, difficulty", nativeQuery = true)
    List<AvgScoreView> getAvgScoreByGameAndDifficulty();

}
