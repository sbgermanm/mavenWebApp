/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample3.maverwebapp.controller;


import com.sebas.jbasample3.maverwebapp.entity.Usuario;
import com.sebas.jbasample3.maverwebapp.service.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Sebasy
 */
@Controller
public class UserController {
    
    @Autowired
    private UserService userService;
   
    @ModelAttribute("bindUserObject")
    public Usuario constructUsuario(){
        return new Usuario();
    }
     
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

    @RequestMapping("/register")
    public String showRegister(){
        return "registroUsuarioTilesDefinition";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(@ModelAttribute("bindUserObject") Usuario usuario){
        userService.save(usuario);
        return "redirect:/register.html?success=true";
    }

    @RequestMapping("/account")
    public String perfil(Model modelo, Principal principal){
        String name = principal.getName();
        modelo.addAttribute("usuario", userService.findOneWithBlogsAndItem(name));
        return "perfilUsuarioTilesDefinition";
    }

}
