package com.matrix.tienda.video.prueba.tecnica.clientes.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.matrix.tienda.video.prueba.tecnica.clientes.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
