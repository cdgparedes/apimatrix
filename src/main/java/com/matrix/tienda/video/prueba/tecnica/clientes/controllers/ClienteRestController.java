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
	

	/**
	 * Método permite obtener listado  de clientes 
	 * 
	 * Entrada :
	 * 		 No recibe parametros
	 * @return Lista de Clientes
	 *
	 * 	
	 */
	@GetMapping("/listaclientes")
	public List<Cliente> listaClientes(){
		return clienteService.findAll();
		
	}
	
	/**
	 * Método permite obtener cliente por id
	 * 
	 * Entrada :
	 * 		 idCliente   Parámetro que contiene  id cliente tipo entero 
	 * @return cliente Objeto de tipo Cliente con los datos;
	 * @return código de estado (NOT_FOUND, INTERNAL_SERVER_ERROR, OK)
	 * 	
	 */
	@GetMapping("/listaclientes/{idCliente}")
	public ResponseEntity<?> listaClientePorId(@PathVariable Long idCliente){
		
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
	

	/**
	 * Método que permite crear clientes
	 * 
	 * Entrada :
	 * 		 cliente  objeto de tipo Cliente 
	 * @return Map con los datos del cliente creado y un mensaje de error ó de exito si se creó bien 
	 * @return código de estado ( INTERNAL_SERVER_ERROR, CREATED )
	 * 	
	 */
	
	@PostMapping("/crearclientes")
	public ResponseEntity<?>  crearclientes(@RequestBody Cliente cliente) {
		
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
	
	

	/**
	 * Método que permite actualizar un  clientes
	 * 
	 * Entrada :
	 * 		 cliente  objeto de tipo Cliente 
	 * 		 idCliente id del cliente con el que se va actualizar en base de datos 
	 * 
	 * @return response Map con los datos del cliente actualiazado y un mensaje de error ó de exito si se actualizo bien 
	 * @return código de estado (NOT_FOUND, INTERNAL_SERVER_ERROR, CREATED)
	 * 	
	 */
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
			response.put("mensaje","Error actualizando  la base de Datos");
			response.put("error",e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			return new 	ResponseEntity<Map<String,Object>>(response,org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje","El cliente se creó exitosamente");
		response.put("cliente",clienteUpdated);
		return new  ResponseEntity<Map<String,Object>> (response, org.springframework.http.HttpStatus.CREATED);
		
	}
	
	/**
	 * Método que permite eliminar un  clientes
	 * 
	 * Entrada :
	 * 		 
	 * 		 idCliente id del cliente con el que se va elimar en base de datos 
	 * 
	 * @return response Map con los datos del cliente eliminado 
	 * @return código de estado (INTERNAL_SERVER_ERROR, OK)
	 * 	
	 */
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
