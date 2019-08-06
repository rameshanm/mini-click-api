package com.example.miniclick.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Gamer {

    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String game;

    private String difficulty;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private int score;

}