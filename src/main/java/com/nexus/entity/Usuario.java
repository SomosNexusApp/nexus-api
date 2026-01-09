package com.nexus.entity;

import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;

@Entity
public class Usuario extends Actor {
	private String telefono;
	private Boolean esVerificado;
	
	@URL
	private String fotoPerfil;
	
	private String biografia;
	
	private String ubicacion;
	
	@Min(0)
	private Integer reputacion;

	public Usuario() {
		super();
		this.esVerificado = false;
		this.reputacion = 0;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getEsVerificado() {
		return esVerificado;
	}

	public void setEsVerificado(Boolean esVerificado) {
		this.esVerificado = esVerificado;
	}

	public String getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(String fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getReputacion() {
		return reputacion;
	}

	public void setReputacion(Integer reputacion) {
		this.reputacion = reputacion;
	}
}
