package com.example.backend.models.services;

import java.util.List;

import com.example.backend.models.Rol;
import com.example.backend.models.Usuario;

public interface UsuarioService {

	public List<Usuario> findAll();

	public Usuario save(Usuario usuario);

	public void delete(Long id);

	public Usuario findById(Long id);

	public List<Rol> findAllRoles();

	public List<Usuario> findAllByOrderByIdAsc();
	
	public List<Usuario> findByUsernameOrNombrePersona(String termino);

}
