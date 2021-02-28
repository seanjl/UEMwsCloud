package com.example.demo.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidad.Usuario;
import com.example.demo.persistencia.DaoUsuario;

@Service
public class GestorUsuario {

	@Autowired
	private DaoUsuario daoUsuario;

	public boolean validarUsuario(Usuario usuario) {
		Usuario aux = daoUsuario.findByNombreAndPassword(usuario.getNombre(), usuario.getPassword());

		if (aux != null) {
			return true;
		} else {
			return false;
		}
	}

}
