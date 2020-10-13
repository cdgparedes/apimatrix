package com.matrix.tienda.video.prueba.tecnica.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="juegos")
public class Juego implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idJuego;
	
	private Long idCliente;
	@Column(name="nombre_juego")
	private String nombreJuego;
	private String titulo;
	private String estado;
	private String director;
	private String protagonista;
	private String productor;
	private String marca;
	private String año;
	private String tecnologia;
	private int precio;
	
	@Column(name="fecha_alquiler")
	@Temporal(TemporalType.DATE)
	private Date fechaAlquiler;
	@Column(name="fecha_entrega")
	@Temporal(TemporalType.DATE)
	private Date fechaEntrega;

	public Long getIdJuego() {
		return idJuego;
	}

	public void setIdJuego(Long idJuego) {
		this.idJuego = idJuego;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getProtagonista() {
		return protagonista;
	}

	public void setProtagonista(String protagonista) {
		this.protagonista = protagonista;
	}

	public String getProductor() {
		return productor;
	}

	public void setProductor(String productor) {
		this.productor = productor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getFechaAlquiler() {
		return fechaAlquiler;
	}

	public void setFechaAlquiler(Date fechaAlquiler) {
		this.fechaAlquiler = fechaAlquiler;
	}

	public Date getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getNombreJuego() {
		return nombreJuego;
	}

	public void setNombreJuego(String nombreJuego) {
		this.nombreJuego = nombreJuego;
	}

	@Override
	public String toString() {
		return "Juego [idJuego=" + idJuego + ", idCliente=" + idCliente + ", nombreJuego=" + nombreJuego + ", titulo="
				+ titulo + ", estado=" + estado + ", director=" + director + ", protagonista=" + protagonista
				+ ", productor=" + productor + ", marca=" + marca + ", año=" + año + ", tecnologia=" + tecnologia
				+ ", precio=" + precio + ", fechaAlquiler=" + fechaAlquiler + ", fechaEntrega=" + fechaEntrega + "]";
	}
	
	
	
	
	


}
