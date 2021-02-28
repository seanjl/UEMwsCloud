package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.modelo.entidad.Videojuego;
import com.example.demo.modelo.persistencia.DaoVideojuego;

@SpringBootApplication
@ComponentScan("modelo.persistencia.DaoVideojuego")
public class EjercicioJpaApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioJpaApplication.class, args);

		DaoVideojuego daoVideojuego = context.getBean("daoVideojuego", DaoVideojuego.class);

		// Ejercicio CRUD

		// CREATE
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

		// READ
		System.out.println("\n VIDEOJUEGOS:");
		List<Videojuego> listaVideojuegos = daoVideojuego.findAll();
		for (Videojuego videojuego : listaVideojuegos) {
			System.out.println(videojuego);
		}

		// UPDATE -> game2 se sobreescribe
		Videojuego game4 = new Videojuego();
		game4.setId(2);
		game4.setNombre("Among Us");
		game4.setCompañia("Inner Sloth");
		game4.setPrecio(0);
		daoVideojuego.save(game4);

		// READ -> lista tras sobreescribir
		System.out.println("\n VIDEOJUEGOS NEW 'replaced 'TloU2' por 'Among Us'");
		List<Videojuego> listUpdated = daoVideojuego.findAll();
		
		for (Videojuego game : listUpdated) {
			System.out.println(game);
		}

		// DELETE
		daoVideojuego.deleteById(1);

		// READ -> lista tras eliminar
		System.out.println("\n VIDEOJUEGOS NEW (deleted 'Cyberpunk 2077')");
		List<Videojuego> listDeleted = daoVideojuego.findAll();

		for (Videojuego game : listDeleted) {
			System.out.println(game);
		}
	}

}
