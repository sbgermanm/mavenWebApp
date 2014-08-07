/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample3.maverwebapp.service;

import com.sebas.jbasample3.maverwebapp.entity.Blog;
import com.sebas.jbasample3.maverwebapp.entity.Item;
import com.sebas.jbasample3.maverwebapp.entity.Role;
import com.sebas.jbasample3.maverwebapp.entity.Usuario;
import com.sebas.jbasample3.maverwebapp.repository.BlogRepository;
import com.sebas.jbasample3.maverwebapp.repository.ItemRepository;
import com.sebas.jbasample3.maverwebapp.repository.RoleRepository;
import com.sebas.jbasample3.maverwebapp.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebasy
 */
@Transactional
@Service
public class DataBaseInitializer {
    
    @Autowired
    private BlogRepository blogRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private ItemRepository itemRepository;
    
    @PostConstruct
    public void initDB()
    {
        Role role1 = new Role("PELOTUDO");
        roleRepository.save(role1);
        
        Role role2 = new Role("PUTO_AMO");
        roleRepository.save(role2);
        
        List<Role> misRoles = new ArrayList<Role>();
        misRoles.add(role1);
        misRoles.add(role2);
        Usuario usuario = new Usuario("Yo", misRoles);
        usuarioRepository.save(usuario);
        
        Blog blog = new Blog("JavavidBlog", "http://feeds.feedburner.com/javavids?format=xml", usuario);
        blogRepository.save(blog);
        
        Item item1 = new Item("PrimerArticulo", new Date(), blog, "www.javavids.com");
        itemRepository.save(item1);
        
        Item item2 = new Item("SegundoArticulo", new Date(), blog, "www.javavids.com");
        itemRepository.save(item2);
        
    }
}
