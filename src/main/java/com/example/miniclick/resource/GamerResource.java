package com.example.miniclick.resource;

import java.util.List;
import java.util.Optional;

import com.example.miniclick.model.Gamer;
import com.example.miniclick.model.vm.ScoreView;
import com.example.miniclick.repository.GamerRepository;
import com.example.miniclick.service.GamerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/gamer")
public class GamerResource {

    @Autowired
    private GamerService gamerService;

    @Autowired
    private GamerRepository gamerRepo;

    @GetMapping()
    private List<Gamer> getAllGamers() {
        // Pageable pageable = PageRequest.of(0, 30);
        // return gamerService.getAllGamers(pageable);
        return gamerService.getAllGamers();
    }

    @GetMapping("/{id}")
    private Optional<Gamer> getGamerById(@PathVariable("id") Long id) {
        return gamerService.getGamerById(id);
    }

    @GetMapping("/game/{game}")
    private Optional<List<Gamer>> getAllGamerByGame(@PathVariable("game") String game) {
        return gamerService.getGamerByGame(game);
    }

    @GetMapping("/score/max_score")
    private List<ScoreView> getHighestScore() {
        List<ScoreView> result = gamerRepo.getMaxScoreOfAllGame();
        return result;
    }

    @GetMapping("/score/min_score")
    private List<ScoreView> getLowScore() {
        List<ScoreView> result = gamerRepo.getMinScoreOfAllGame();
        return result;
    }

    @GetMapping("/score/avg_score")
    private List<ScoreView> getAvgScore() {
        List<ScoreView> result = gamerRepo.getAvgScoreOfAllGame();
        return result;
    }

}
