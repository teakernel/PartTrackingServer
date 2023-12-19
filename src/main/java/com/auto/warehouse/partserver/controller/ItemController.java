package com.auto.warehouse.partserver.controller;

import com.auto.warehouse.partserver.entity.Item;
import com.auto.warehouse.partserver.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @PostMapping("/newItem")
    public ResponseEntity<Item> newItem(@RequestBody Item item){
        try{
            Item _item = itemRepository.save(new Item(item.getName(), item.getDescription(), item.getLocation(),item.getSku()));
            return new ResponseEntity<>(_item, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
