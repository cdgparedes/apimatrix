package com.matrix.tienda.video.prueba.tecnica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.matrix.tienda.video.prueba.tecnica.models.entity.Juego;
import com.matrix.tienda.video.prueba.tecnica.models.services.IJuegoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/juego")
public class JuegoRestController {
	
	@Autowired
	private IJuegoService juegoService;
	
	@GetMapping("/listarjuegos")
	public List<Juego> index(){
		return juegoService.findAll();
		
	}
	
	@GetMapping("/listarjuegos/{idJuego}")
	public Juego show(@PathVariable Long idJuego){
		return juegoService.findById(idJuego);
		
	}
	
	@PostMapping("/crearjuego")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Juego create(@RequestBody Juego juego) {
		return juegoService.save(juego);
	}
	
	@PutMapping("/actualizarjuegos/{idJuego}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Juego udpate(@RequestBody Juego juego, @PathVariable Long idJuego) {
		Juego juegoActual = juegoService.findById(idJuego);
		juegoActual.setNombreJuego(juego.getNombreJuego());
		juegoActual.setTitulo(juego.getTitulo());
		juegoActual.setEstado(juego.getEstado());
		return juegoService.save(juegoActual);
		
	}
	
	
	@DeleteMapping("/borrarjuego/{idJuego}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete( @PathVariable Long idJuego) {
		juegoService.delete(idJuego);
}
}
