package com.matrix.tienda.video.prueba.tecnica.models.services;

import java.util.List;


import com.matrix.tienda.video.prueba.tecnica.models.entity.Juego;

public interface IJuegoService {
	public List<Juego> findAll(); 
	public Juego findById(Long id); 
	public Juego  save(Juego cliente); 
	public void delete(Long idCliente);

}
