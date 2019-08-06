package com.example.miniclick.model.vm;

import com.example.miniclick.model.Gamer;

import org.springframework.data.rest.core.config.Projection;

public interface AvgScoreView {
    String getGame();
    String getDifficulty();
    Double getAvgScore();
}