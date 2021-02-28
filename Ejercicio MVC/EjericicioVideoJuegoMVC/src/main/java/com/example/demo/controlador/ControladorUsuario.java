package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidad.Usuario;
import com.example.demo.entidad.Videojuego;
import com.example.demo.modelo.negocio.GestorUsuario;
import com.example.demo.modelo.negocio.GestorVideojuego;

@Controller
public class ControladorUsuario {
	
	@Autowired
	private GestorUsuario gestorUsuario;
	
	@Autowired
	private GestorVideojuego gestorVideojuego;
	
	
	@PostMapping("doLogin")
	public String logarse(
			@RequestParam("nombre_usuario") String nombre,
			@RequestParam("password") String password,
			Model model) {
		
		Usuario user = new Usuario();
		user.setNombre(nombre);
		user.setPassword(password);
		
		boolean validado = gestorUsuario.validarUsuario(user);
		
		if (validado) {
			model.addAttribute("nombre_usuario");
			
			List<Videojuego> listaVideojuegos = gestorVideojuego.obtenerLista();
			
			model.addAttribute("lista_videojuegos", listaVideojuegos);
			
			return "inicio";
		} else {
			return "errorlogin";
		}
	}
	
}
