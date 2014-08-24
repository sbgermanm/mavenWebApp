/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample3.maverwebapp.service;

import com.sebas.jbasample3.maverwebapp.entity.Blog;
import com.sebas.jbasample3.maverwebapp.entity.Usuario;
import com.sebas.jbasample3.maverwebapp.repository.BlogRepository;
import com.sebas.jbasample3.maverwebapp.repository.UsuarioRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sgerman
 */
@Service
@Transactional
public class BlogService {

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    BlogRepository blogRepository;
    
    public void save(Blog blog, String name) {
        Usuario usuario = usuarioRepository.findByName(name);
        blog.setUsuario(usuario);
        blogRepository.save(blog);
    }
    
}