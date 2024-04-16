package com.rvm.rvm.controller;

import com.rvm.rvm.entity.Achievement;
import com.rvm.rvm.repository.AchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/achievement")
@RequiredArgsConstructor
public class AchievementController {
    private final AchievementRepository achievementRepository;

    @GetMapping
    public ResponseEntity<Iterable<Achievement>> getAllAchievement() {
        Iterable<Achievement> achievements = achievementRepository.findAll();
        if (!achievements.iterator().hasNext()) {
            return new ResponseEntity<>(achievements, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(achievements, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Achievement> addNewAchievement(@RequestBody Achievement achievement) {
        achievementRepository.save(achievement);
        return new ResponseEntity<>(HttpStatus.CREATED);        
    }
}
