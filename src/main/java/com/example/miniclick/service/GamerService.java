package com.example.miniclick.service;

import java.util.List;
import java.util.Optional;

import com.example.miniclick.model.Gamer;
import com.example.miniclick.repository.GamerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GamerService {

    @Autowired
    private GamerRepository gamerRepo;

    // public Page<Gamer> getAllGamers(Pageable pageable) {
    //     return gamerRepo.findAll(pageable);
    // }

    public List<Gamer> getAllGamers() {
        return gamerRepo.findAll();
    }

	public Optional<Gamer> getGamerById(Long id) {
		return gamerRepo.findById(id);
	}

	public Optional<List<Gamer>> getGamerByGame(String game) {
		return gamerRepo.findAllByGame(game);
    }
    
    public int getHighestScoreByGame(String game) {
        return gamerRepo.getHighestScoreByGame(game);
    }

}