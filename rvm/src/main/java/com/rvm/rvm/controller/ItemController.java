package com.rvm.rvm.controller;

import com.rvm.rvm.entity.Tradeables;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rvm.rvm.repository.TradeableRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tradeable")
@RequiredArgsConstructor
public class ItemController {
    private TradeableRepository tradeableRepository;

    @GetMapping
    public ResponseEntity<Iterable<Tradeables>> getAllTradeable() {
        Iterable<Tradeables> tradeables = tradeableRepository.findAll();
        if(!tradeables.iterator().hasNext()) {
            return new ResponseEntity<>(tradeables, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(tradeables, HttpStatus.OK);
        }
    }
    
    @PostMapping
    public ResponseEntity<Tradeables> addNewTradeable(@RequestBody Tradeables tradeables) {
        tradeableRepository.save(tradeables);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tradeables> updateItemById(@PathVariable Long id, @RequestBody Tradeables newTradeables) {
        if(tradeableRepository.existsById(id)) {
            Tradeables oldTradeables = tradeableRepository.findById(id).get();
            oldTradeables.setHarga(newTradeables.getHarga());
            oldTradeables.setPoints(newTradeables.getPoints());
            tradeableRepository.save(oldTradeables);
            return new ResponseEntity<>(oldTradeables, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
}
