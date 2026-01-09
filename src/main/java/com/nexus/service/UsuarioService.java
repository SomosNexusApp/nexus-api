package com.nexus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexus.entity.Admin;
import com.nexus.entity.Usuario;
import com.nexus.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<Usuario> findById(Integer id) {
		return this.usuarioRepository.findById(id);
	}
	
	public List<Usuario> findAll() {
		return this.usuarioRepository.findAll();
	}
	
	public Usuario save(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}
	
	public Usuario update(Integer id, Usuario usuario) {
		Optional<Usuario> oUsuario = findById(id);
		
		if (oUsuario.isPresent()) {
			Usuario u = oUsuario.get();
			
			u.setUser(usuario.getUser());
			u.setEmail(usuario.getEmail());
			u.setPassword(usuario.getPassword());
			u.setTelefono(usuario.getTelefono());
			u.setEsVerificado(usuario.getEsVerificado());
			u.setFotoPerfil(usuario.getFotoPerfil());
			u.setBiografia(usuario.getBiografia());
			u.setUbicacion(usuario.getUbicacion());
			u.setReputacion(usuario.getReputacion());
			
			return save(u);
		}
		return null;
	}
	
	public void delete(Integer id) {
		this.usuarioRepository.deleteById(id);
	}
}
