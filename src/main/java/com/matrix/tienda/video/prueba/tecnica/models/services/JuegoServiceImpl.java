package com.matrix.tienda.video.prueba.tecnica.models.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrix.tienda.video.prueba.tecnica.models.dao.IJuegoDao;
import com.matrix.tienda.video.prueba.tecnica.models.entity.Juego;


@Service
public class JuegoServiceImpl implements IJuegoService{
	
	@Autowired
	private IJuegoDao juegoDao;
	
	@Override
	// @Transactional(readOnly = true)
	public List<Juego> findAll() {
		return (List<Juego>) juegoDao.findAll();
	}

	@Override
	@Transactional
	public Juego findById(Long idJuego) {
		return juegoDao.findById(idJuego).orElse(null);
	}

	@Override
	@Transactional
	public Juego save(Juego juego) {
		return juegoDao.save(juego);
	}

	@Override
	public void delete(Long idJuego) {
		juegoDao.deleteById(idJuego);
		
	}

}
