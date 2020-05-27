package com.example.backend.models.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.models.Rol;
import com.example.backend.models.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	@Query("from Rol")
	public List<Rol> findAllRoles();
	
	public List<Usuario> findAllByOrderByIdAsc();

}
