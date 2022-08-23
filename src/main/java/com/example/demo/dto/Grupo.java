package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="grupo")//en caso que la tabala sea diferente
public class Grupo {
	
	//Atributos de entidad registro_curso
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int id;
		
		@ManyToOne
	    @JoinColumn(name = "id_partida")
	    Partida partida;
	 
	    @ManyToOne
	    @JoinColumn(name = "id_user")
	    Usuario usuario;

		//Constructores
		
		public Grupo() {

		}

		public Grupo(int id, Partida partida, Usuario usuario) {
			this.id = id;
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
			return "Grupo [id=" + id + ", partida=" + partida + ", usuario=" + usuario + "]";
		}

}
