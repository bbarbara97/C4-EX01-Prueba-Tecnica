package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="partida")//en caso que la tabla sea diferente
public class Partida {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int id;
		@Column(name = "nombre")//no hace falta si se llama igual
		private String nombre;
		
		@ManyToOne
	    @JoinColumn(name = "id_juego")
	    Juego juego;
		
		@OneToMany
	    @JoinColumn(name="id")
	    private List<Grupo> grupo;
		
		@OneToMany
	    @JoinColumn(name="id")
	    private List<Mensaje> mensaje;

		//Constructores
		
		public Partida() {

		}

		public Partida(int id, String nombre, Juego juego, List<Grupo> grupo, List<Mensaje> mensaje) {
			this.id = id;
			this.nombre = nombre;
			this.juego = juego;
			this.grupo = grupo;
			this.mensaje = mensaje;
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

		public Juego getJuego() {
			return juego;
		}

		public void setJuego(Juego juego) {
			this.juego = juego;
		}

		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Grupo")
		public List<Grupo> getGrupo() {
			return grupo;
		}

		public void setGrupo(List<Grupo> grupo) {
			this.grupo = grupo;
		}		
		
		@JsonIgnore
		@OneToMany(fetch = FetchType.LAZY, mappedBy = "Mensaje")
		public List<Mensaje> getMensaje() {
			return mensaje;
		}

		public void setMensaje(List<Mensaje> mensaje) {
			this.mensaje = mensaje;
		}

		//Metodo toString

		@Override
		public String toString() {
			return "Partida [id=" + id + ", nombre=" + nombre + ", juego=" + juego + ", grupo=" + grupo + "]";
		}
		
}
