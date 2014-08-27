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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public void initDB() {
        Role role1 = new Role("PELOTUDO");
        roleRepository.save(role1);

        Role role2 = new Role("PUTO_AMO");
        roleRepository.save(role2);

        Role role3 = new Role("ROLE_ADMIN");
        roleRepository.save(role3);

        List<Role> misRoles = new ArrayList<Role>();
        misRoles.add(role1);
        misRoles.add(role2);
        misRoles.add(role3);
        Usuario usuario = new Usuario("sebas", misRoles);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode("sebas"));
        usuario.setEnabled(true);
        usuarioRepository.save(usuario);

        List<Role> pelotudo1Roles = new ArrayList<Role>();
        pelotudo1Roles.add(role1);
        Usuario pelotudo1 = new Usuario("Pelotudo1", pelotudo1Roles);
        pelotudo1.setEnabled(true);
        usuarioRepository.save(pelotudo1);

        List<Role> pelotudo2Roles = new ArrayList<Role>();
        pelotudo2Roles.add(role1);
        Usuario pelotudo2 = new Usuario("Pelotudo2", pelotudo2Roles);
        pelotudo2.setEnabled(true);
        usuarioRepository.save(pelotudo2);

        Blog blog = new Blog("JavavidBlog", "http://feeds.feedburner.com/javavids?format=xml", usuario);
        blogRepository.save(blog);

        Item item1 = new Item("PrimerArticulo", new Date(), blog, "www.javavids.com");
        itemRepository.save(item1);

        Item item2 = new Item("SegundoArticulo", new Date(), blog, "www.javavids.com");
        itemRepository.save(item2);

    }
}
