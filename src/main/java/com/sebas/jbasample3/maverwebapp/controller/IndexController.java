/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample3.maverwebapp.controller;

import com.sebas.jbasample3.maverwebapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * @author Sebasy
 */

@Controller
public class IndexController  {
    
    @Autowired
    ItemService itemService;
    
    @RequestMapping("/index")
    public String index(Model modelo)
    {
        modelo.addAttribute("items", itemService.getAllItems());
        return "index"; 
    }
}
