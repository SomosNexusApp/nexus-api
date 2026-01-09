package com.nexus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexus.entity.Admin;
import com.nexus.repository.AdminRepository;

@Service
public class AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	public Optional<Admin> findById(Integer id) {
		return this.adminRepository.findById(id);
	}
	
	public List<Admin> findAll() {
		return this.adminRepository.findAll();
	}
	
	public Admin save(Admin admin) {
		return this.adminRepository.save(admin);
	}
	
	public Admin update(Integer id, Admin admin) {
		Optional<Admin> oAdmin = findById(id);
		
		if (oAdmin.isPresent()) {
			Admin a = oAdmin.get();
			
			// Actualizamos los campos de Actor (el padre)
			a.setUser(admin.getUser());
			a.setEmail(admin.getEmail());
			a.setPassword(admin.getPassword());
			a.setNivelAcceso(admin.getNivelAcceso());
			
			return save(a);
		}
		return null;
	}
	
	public void delete(Integer id) {
		this.adminRepository.deleteById(id);
	}
}