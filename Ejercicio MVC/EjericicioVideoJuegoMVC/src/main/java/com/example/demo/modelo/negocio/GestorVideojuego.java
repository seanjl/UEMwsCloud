package com.example.demo.modelo.negocio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Videojuego;
import com.example.demo.persistencia.DaoVideojuego;

@Service
public class GestorVideojuego {

	@Autowired
	private DaoVideojuego daoVideojuego;

	public List<Videojuego> obtenerLista() {
		return daoVideojuego.findAll();
	}

	public Videojuego buscarVideojuego(int id) {
		Optional<Videojuego> optVideojuego = daoVideojuego.findById(id);

		if (optVideojuego.isPresent()) {
			return optVideojuego.get();
		} else {
			return null;
		}

	}
}
