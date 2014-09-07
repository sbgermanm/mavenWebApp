/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebas.jbasample3.maverwebapp.service;

import com.sebas.jbasample3.maverwebapp.entity.Item;
import com.sebas.jbasample3.maverwebapp.repository.ItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 *
 * @author sgerman
 */
@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll(new PageRequest(0, 20, Sort.Direction.DESC, "publishDate")).getContent();
    }

    
}
