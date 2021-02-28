package com.example.demo.modelo.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.entidad.Videojuego;

@Repository
public interface DaoVideojuego extends JpaRepository<Videojuego, Integer> {

}
