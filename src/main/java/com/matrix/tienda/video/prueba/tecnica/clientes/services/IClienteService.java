package com.matrix.tienda.video.prueba.tecnica.clientes.services;

import java.util.List;

import com.matrix.tienda.video.prueba.tecnica.clientes.models.entity.Cliente;


public interface IClienteService {
	public List<Cliente> findAll(); 
	public Cliente findById(Long id); 
	public Cliente  save(Cliente cliente); 
	public void delete(Long idCliente);
	

}
