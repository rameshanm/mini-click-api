package com.example.miniclick.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.miniclick.model.Gamer;
import com.example.miniclick.model.vm.AvgScoreView;
import com.example.miniclick.service.ScoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/score")
public class ScoreResource {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/1")
    public List<AvgScoreView> getAvgScoreByGameAndDifficulty() {
        return scoreService.getAvgScoreByGameAndDifficulty();
    }

}