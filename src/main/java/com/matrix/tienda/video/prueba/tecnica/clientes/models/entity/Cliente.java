package com.matrix.tienda.video.prueba.tecnica.clientes.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="clientes")
public class Cliente implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(name="nombre_cliente")
	private String nombreCliente;
	
	@Column(nullable=false, unique=true)
	private String documento;
	private String estado;
	private int edad;
	private String email;
	@Column(name="fecha_registro")
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@PrePersist
	public void prePerist() {
		fechaRegistro = new Date();
	}
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", documento=" + documento
				+ ", estado=" + estado + ", edad=" + edad + ", email=" + email + ", fechaRegistro=" + fechaRegistro
				+ "]";
	}
	
	
	
	
	
}
