package com.example.backend.security.jwt;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.backend.models.Usuario;
import com.example.backend.models.repositories.UsuarioRepository;
import com.example.backend.security.services.UserDetailsImpl;



public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user=userRepository.findByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException(String.format("Usuario No encontrado con username: ", username));
		}
		else {
			//return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
			return UserDetailsImpl.build(user);	
		}
		
	}
}
