/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sebas.jbasample3.maverwebapp.service;

import com.sebas.jbasample3.maverwebapp.entity.Blog;
import com.sebas.jbasample3.maverwebapp.entity.Item;
import com.sebas.jbasample3.maverwebapp.entity.Usuario;
import com.sebas.jbasample3.maverwebapp.exceptions.RssException;
import com.sebas.jbasample3.maverwebapp.repository.BlogRepository;
import com.sebas.jbasample3.maverwebapp.repository.ItemRepository;
import com.sebas.jbasample3.maverwebapp.repository.UsuarioRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    RssService rssService;

    public void save(Blog blog, String name) {
        Usuario usuario = usuarioRepository.findByName(name);
        blog.setUsuario(usuario);
        blogRepository.save(blog);
        saveItems(blog);
    }

    @PreAuthorize("#blog.usuario.name == authentication.name or hasRole('ROLE_ADMIN')")
    public void delete(@P("blog") Blog blog) {
        blogRepository.delete(blog);
    }

    public Blog findOne(int id) {

        return blogRepository.findOne(id);
    }

    private void saveItems(Blog blog) {
        try {
            List<Item> articulos = rssService.getItems(blog.getUrl());
            for (Item articulo : articulos) {
                Item savedItem = itemRepository.findByBlogAndLink(blog, articulo.getLink());
                if (null == savedItem) {
                    articulo.setBlog(blog);
                    itemRepository.save(articulo);
                }
            }
        } catch (RssException ex) {
            Logger.getLogger(BlogService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Scheduled(fixedDelay = 60*60*1000)
    public void updateBlogs(){
        List<Blog> allBlogs = blogRepository.findAll();
        for (Blog blog : allBlogs) {
            saveItems(blog);
        }
    }
}
