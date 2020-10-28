package com.example.backend.models.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.backend.models.Rol;
import com.example.backend.models.Usuario;
import com.example.backend.models.repositories.UsuarioRepository;
import com.example.backend.models.services.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll() {
		return usuarioRepository.findAllByOrderByIdAsc();
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public void delete(Long id) {
		usuarioRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public List<Rol> findAllRoles() {
		return usuarioRepository.findAllRoles();
	}

	@Override
	public List<Usuario> findAllByOrderByIdAsc() {
		return usuarioRepository.findAllByOrderByIdAsc();
	}

	@Override
	public List<Usuario> findByUsernameOrNombrePersona(String termino) {
		return usuarioRepository.findByUsernameOrNombrePersona(termino);
	}

	@Override
	public Usuario findByUsername(String username) {
		return usuarioRepository.findByUsername(username);
	}

}
