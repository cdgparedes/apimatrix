package com.matrix.tienda.video.prueba.tecnica.clientes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.matrix.tienda.video.prueba.tecnica.clientes.models.entity.Cliente;
import com.matrix.tienda.video.prueba.tecnica.clientes.services.IClienteService;


@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/cliente")
public class ClienteRestController {
	
	private static final HttpStatus HttpStatus = null;
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listaclientes")
	public List<Cliente> index(){
		return clienteService.findAll();
		
	}
	
	@GetMapping("/listaclientes/{idCliente}")
	public ResponseEntity<?> show(@PathVariable Long idCliente){
		
		Map<String,Object> response = new HashMap<>();
		Cliente cliente = null;
		try {
			cliente = clienteService.findById(idCliente);
		}catch(DataAccessException e){
			response.put("mensaje","Error consultando la base de Datos");
			response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new 	ResponseEntity<Map<String,Object>>(response,org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if(cliente == null) {
			response.put("mensaje","El cliente ID:".concat(idCliente.toString().concat("no existe en la base de datos!")));
			return new 	ResponseEntity<Map<String,Object>>(response,org.springframework.http.HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<Cliente> (cliente,org.springframework.http.HttpStatus.OK);
		
	}
	
	@PostMapping("/crearclientes")
	public ResponseEntity<?>  create(@RequestBody Cliente cliente) {
		
		Cliente clienteNew = null;
		Map<String,Object> response = new HashMap<>();
		try {
			clienteNew = clienteService.save(cliente);
		}catch(DataAccessException e){
			response.put("mensaje","Error consultando la base de Datos");
			response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new 	ResponseEntity<Map<String,Object>>(response,org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje","El cliente se creó exitosamente");
		response.put("cliente",clienteNew);
		return new  ResponseEntity<Map<String,Object>> (response, org.springframework.http.HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizaclientes/{idCliente}")
	public ResponseEntity<?> udpate(@RequestBody Cliente cliente, @PathVariable Long idCliente) {
		
		Cliente clienteActual = clienteService.findById(idCliente);
		Cliente clienteUpdated= null;
		Map<String,Object> response = new HashMap<>();
		if(cliente == null) {
			response.put("mensaje","Error: no se pudo editar, el cliente ID:".concat(idCliente.toString().concat("no existe en la base de datos!")));
			return new 	ResponseEntity<Map<String,Object>>(response,org.springframework.http.HttpStatus.NOT_FOUND);
		}
		try {
			clienteActual.setNombreCliente(cliente.getNombreCliente());
			clienteActual.setEmail(cliente.getEmail());
			clienteActual.setDocumento(cliente.getDocumento());
			clienteActual.setEstado(cliente.getEstado());
			clienteActual.setEdad(cliente.getEdad());
			clienteUpdated= clienteService.save(clienteActual);
		}catch (DataAccessException e){
			response.put("mensaje","Error actualizando en  la base de Datos");
			response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new 	ResponseEntity<Map<String,Object>>(response,org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El cliente se creó exitosamente");
		response.put("cliente",clienteUpdated);
		return new  ResponseEntity<Map<String,Object>> (response, org.springframework.http.HttpStatus.CREATED);
		
	}
	
	
	@DeleteMapping("/borrarcliente/{idCliente}")	
	public ResponseEntity<?> delete( @PathVariable Long idCliente) {
		Map<String,Object> response = new HashMap<>();
		try {
			clienteService.delete(idCliente);
		}catch (DataAccessException e){
			response.put("mensaje","Error al eliminar cliente de la base de datos ");
			response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new 	ResponseEntity<Map<String,Object>>(response,org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		
		}
		
		response.put("mensaje", "El cliente ha sido eliminado con exito!");
		
		return new ResponseEntity<Map<String,Object>>(response,org.springframework.http.HttpStatus.OK);
		
   }
	
	
}
