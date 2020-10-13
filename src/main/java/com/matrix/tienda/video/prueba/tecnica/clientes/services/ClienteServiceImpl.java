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
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	public void delete(Long idCliente) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(idCliente);
	}

}
