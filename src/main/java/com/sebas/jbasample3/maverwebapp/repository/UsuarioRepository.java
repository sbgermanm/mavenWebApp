/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sebas.jbasample3.maverwebapp.repository;


import com.sebas.jbasample3.maverwebapp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Sebasy
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    public Usuario findByName(String name);
    
    
}
