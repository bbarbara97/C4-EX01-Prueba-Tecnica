package com.example.demo.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="mensaje")//en caso que la tabla sea diferente
public class Mensaje {

	//Atributos de entidad estudiante
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int id;
		@Column(name = "contenido")//no hace falta si se llama igual
		private String contenido;
		
		@ManyToOne
	    @JoinColumn(name = "id_partida")
	    Partida partida;
		
		@ManyToOne
	    @JoinColumn(name = "id_user")
	    Usuario usuario;
	

		//Constructores
		
		public Mensaje() {

		}

		public Mensaje(int id, String contenido, Partida partida, Usuario usuario) {
			this.id = id;
			this.contenido = contenido;
			this.partida = partida;
			this.usuario = usuario;
		}

		//Getters y Setters

		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getContenido() {
			return contenido;
		}

		public void setContenido(String contenido) {
			this.contenido = contenido;
		}

		public Partida getPartida() {
			return partida;
		}

		public void setPartida(Partida partida) {
			this.partida = partida;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		//Metodo toString
		
		@Override
		public String toString() {
			return "Mensaje [id=" + id + ", contenido=" + contenido + ", partida=" + partida + ", usuario=" + usuario
					+ "]";
		}	
		
}
