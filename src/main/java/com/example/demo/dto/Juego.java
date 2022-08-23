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
@Table(name="juego")
public class Juego {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		@Column(name = "nombre")
		private String nombre;
		@Column(name = "url")
		private String url;
		
		@OneToMany
	    @JoinColumn(name="id")
	    private List<Partida> partida;

		//Constructores
		
		public Juego() {

		}

		public Juego(int id, String nombre, String url, List<Partida> partida) {
			this.id = id;
			this.nombre = nombre;
			this.url = url;
			this.partida = partida;
		}



		//Getters y Setters

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Partida")
		public List<Partida> getPartida() {
			return partida;
		}

		public void setPartida(List<Partida> partida) {
			this.partida = partida;
		}
		
		//Metodo toString
		
		@Override
		public String toString() {
			return "Juego [id=" + id + ", nombre=" + nombre + ", url=" + url + ", partida=" + partida + "]";
		}
		
		
}
