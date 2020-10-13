package com.matrix.tienda.video.prueba.tecnica.clientes.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.tienda.video.prueba.tecnica.clientes.models.dao.IClienteDao;
import com.matrix.tienda.video.prueba.tecnica.clientes.models.entity.Cliente;


@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	public void delete(Long idCliente) {
		clienteDao.deleteById(idCliente);
	}

}
