/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.backend.models.services;

import com.example.backend.models.Persona;
import java.util.List;

/**
 *
 * @author Andy
 */
public interface PersonaService {

    public List<Persona> findAll();

    public Persona save(Persona persona);

    public void delete(Long id);
    
    public Persona findById(Long id);

}
