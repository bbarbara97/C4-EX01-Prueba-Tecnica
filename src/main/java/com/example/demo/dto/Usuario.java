package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuario")
public class Usuario {

	//Atributos de entidad estudiante
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "steam_user")
	private String steam_user;

	@OneToMany
	@JoinColumn(name="id")
	private List<Mensaje> mensaje;
	@OneToMany
	@JoinColumn(name="id")
	private List<Grupo> grupo;

	//Constructores

	public Usuario() {

	}

	public Usuario(int id, String username, String password, String email, String steam_user, List<Mensaje> mensaje,
			List<Grupo> grupo) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.steam_user = steam_user;
		this.mensaje = mensaje;
		this.grupo = grupo;
	}

	//Getters y Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSteam_user() {
		return steam_user;
	}

	public void setSteam_user(String steam_user) {
		this.steam_user = steam_user;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Mensaje")
	public List<Mensaje> getMensaje() {
		return mensaje;
	}

	public void setMensaje(List<Mensaje> mensaje) {
		this.mensaje = mensaje;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Grupo")
	public List<Grupo> getGrupo() {
		return grupo;
	}

	public void setGrupo(List<Grupo> grupo) {
		this.grupo = grupo;
	}

	//Metodo toString

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", steam_user=" + steam_user + ", mensaje=" + mensaje + ", grupo=" + grupo + "]";
	}
}
