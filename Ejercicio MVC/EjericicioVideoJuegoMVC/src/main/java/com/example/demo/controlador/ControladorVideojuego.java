package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entidad.Videojuego;
import com.example.demo.modelo.negocio.GestorVideojuego;

@Controller
public class ControladorVideojuego {

	@Autowired
	private GestorVideojuego gestorVideojuego;
	
	// cuándo el navegador hace un get 'consultarVideojuegoId' se llama a este método
	@GetMapping("consultarVideojuegoId")
	public String consultarVideojuegoId(@RequestParam("id_videojuego") int id, Model model) {
		Videojuego videojuego = gestorVideojuego.buscarVideojuego(id);
		
		System.out.println("\n" + videojuego);
		
		model.addAttribute("videojuego", videojuego);
		
		return "busquedaid";
	}
	
	@GetMapping("regresar_listado")
	public String regresar(Model model) {
		List<Videojuego> listaVideojuegos = gestorVideojuego.obtenerLista();
		
		model.addAttribute("lista_videojuegos", listaVideojuegos);
		
		return "inicio";
	}

}
