/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample3.maverwebapp.controller;


import com.sebas.jbasample3.maverwebapp.entity.Usuario;
import com.sebas.jbasample3.maverwebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sebasy
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
    
     
    @RequestMapping("/users")
    public String getAllUsers(Model modelo){
        modelo.addAttribute("listaDeUsuarios", userService.findAll());
        return "listadoUsuarioTilesDefinition";
    }
    
    @RequestMapping("/users/{id}")
    public String userDetail(Model modelo, @PathVariable int id){
        modelo.addAttribute("usuario", userService.findOneWithBlogsAndItem(id));
        return "detalleUsuarioTilesDefinition";
    }
}
