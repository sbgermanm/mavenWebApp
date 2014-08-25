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
import java.util.List;
import java.util.prefs.Preferences;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebasy
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findOne(int id) {
        return usuarioRepository.findOne(id);
    }

    @Transactional
    public Usuario findOneWithBlogsAndItem(int id) {
        Usuario usuario = usuarioRepository.findOne(id);
        return findOneWithBlogsAndItem(usuario);

    }

    public Usuario findOneWithBlogsAndItem(Usuario usuario) {
        List<Blog> blogs = blogRepository.findByUsuario(usuario);
        for (Blog blog : blogs) {
            List<Item> articulos = itemRepository.findByBlog(blog, new PageRequest(0, 10, Sort.Direction.DESC, "publishDate"));
            blog.setItems(articulos);
        }
        usuario.setBlogs(blogs);
        return usuario;
    }

    public void save(Usuario usuario) {
        usuario.setEnabled(true);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        usuario.setPassword(encoder.encode(usuario.getPassword()));

        Role role = roleRepository.findByName("PELOTUDO");
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        usuario.setRoles(roles);

        usuarioRepository.save(usuario);
    }

    public Usuario findOneWithBlogsAndItem(String name) {
        Usuario usuario = usuarioRepository.findByName(name);
        return findOneWithBlogsAndItem(usuario);
    }

    public void delete(int id) {
        usuarioRepository.delete(id);
    }
}
