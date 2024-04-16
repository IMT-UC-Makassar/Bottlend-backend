package com.rvm.rvm.controller;

import com.rvm.rvm.entity.History;
import com.rvm.rvm.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryRepository historyRepository;

    @GetMapping
    public ResponseEntity<Iterable<History>> getAllHistory() {
        Iterable<History> histories = historyRepository.findAll();
        if (!histories.iterator().hasNext()) {
            return new ResponseEntity<>(histories, HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(histories, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<History> addNewHistory(@RequestBody History history) {
        historyRepository.save(history);
        return new ResponseEntity<>(HttpStatus.CREATED);        
    }
}
