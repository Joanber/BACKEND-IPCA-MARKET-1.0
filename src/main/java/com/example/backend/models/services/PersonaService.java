/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend.models.services;

import com.example.backend.models.Persona;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Andy
 */
public interface PersonaService {

    public List<Persona> findAll();

    public Persona save(Persona persona);

    public void delete(Long id);
    
    public Persona findById(Long id);
    
    public List<Persona> findAllByOrderByIdAsc();
    
    public List<Persona> findByNombreOrApellido(String nombre);
    
    public Page<Persona> findAll(Pageable pageable);

}
