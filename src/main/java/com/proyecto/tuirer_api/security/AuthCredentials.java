package com.proyecto.tuirer_api.security;


public class AuthCredentials {

	private String nombreUsuario;
	private String password;
	
	
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void nombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
