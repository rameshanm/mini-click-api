package com.example.miniclick.model.vm;

import com.example.miniclick.model.Gamer;

import org.springframework.data.rest.core.config.Projection;

// @Projection(name = "score", types = { Gamer.class }) 
public interface ScoreView {
    String getGame();
    Double getScore();
}
