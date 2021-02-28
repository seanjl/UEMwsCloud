package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.entidad.Videojuego;
import com.example.demo.entidad.Usuario;
import com.example.demo.persistencia.DaoVideojuego;
import com.example.demo.persistencia.DaoUsuario;

@SpringBootApplication
public class EjericicioVideoJuegoMvcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjericicioVideoJuegoMvcApplication.class, args);
		
		// Todo lo que se va a acceder desde el navegador y no con un controlador va en
		// static

		DaoVideojuego daoVideojuego = context.getBean("daoVideojuego", DaoVideojuego.class);

		DaoUsuario daoUsuario = context.getBean("daoUsuario", DaoUsuario.class);

		Videojuego game1 = new Videojuego();
		game1.setNombre("Cyberpunk 2077");
		game1.setCompañia("CD Projekt");
		game1.setPrecio(77);
		daoVideojuego.save(game1);

		Videojuego game2 = new Videojuego();
		game2.setNombre("The Last of Us Part II");
		game2.setCompañia("Naughty Dog");
		game2.setPrecio(65);
		daoVideojuego.save(game2);

		Videojuego game3 = new Videojuego();
		game3.setNombre("Call Of Duty Warzone");
		game3.setCompañia("Treyarch");
		game3.setPrecio(70);
		daoVideojuego.save(game3);

		Usuario user1 = new Usuario();
		user1.setNombre("usuario");
		user1.setPassword("aX3kQzrT");
		daoUsuario.save(user1);

		List<Videojuego> lista = daoVideojuego.findAll();
		for (Videojuego game : lista) {
			System.out.println(game);
		}
		
		System.out.println(user1);

	}
}

