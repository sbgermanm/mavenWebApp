/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebas.jbasample3.maverwebapp.controller;

import com.sebas.jbasample3.maverwebapp.entity.Usuario;
import com.sebas.jbasample3.maverwebapp.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author sgerman
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @ModelAttribute("bindUserObject")
    public Usuario constructUsuario() {
        return new Usuario();
    }

    @RequestMapping
    public String showRegister() {
        return "registroUsuarioTilesDefinition";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doRegister(@Valid @ModelAttribute("bindUserObject") Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showRegister();
        }
        userService.save(usuario);
        return "redirect:/register.html?success=true";
    }

}
