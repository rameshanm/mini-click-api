package com.example.miniclick.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.persistence.Tuple;

import com.example.miniclick.model.vm.AvgScoreView;
import com.example.miniclick.repository.GamerRepository;

import org.springframework.stereotype.Service;

@Service
public class ScoreService {

    @Resource
    private GamerRepository gamerRepository;

    public Double getAvgScoreByGame(String game) {
        return gamerRepository.getAvgScoreByGame(game);
    }

    public Map<String, Double> getAvgScoreofAllGames() {
        List<Tuple> list = gamerRepository.getAvgScoreOfAllGame();
        Map<String, Double> avgScoreMap = new HashMap<>();
        for (Tuple item : list) {
            System.out.println(item.toString());
        }
        return avgScoreMap;
    }

    public List<AvgScoreView> getAvgScoreByGameAndDifficulty() {
        List<AvgScoreView> list = gamerRepository.getAvgScoreByGameAndDifficulty();
        return list;
    }
}