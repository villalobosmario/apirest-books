package com.company.books.backend.service;

import java.util.*;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.books.backend.dao.ICategoriaDao;
import com.company.books.backend.dao.ILibroDao;
import com.company.books.backend.model.Categoria;
import com.company.books.backend.model.Libro;
import com.company.books.backend.response.CategoriaResponseRest;
import com.company.books.backend.response.LibroResponseRest;



@Service
public class LibroServiceImpl implements ILibroService {

	private static final Logger log = LoggerFactory.getLogger(LibroServiceImpl.class);
	
	@Autowired
	private ILibroDao libroDao;
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity<LibroResponseRest> buscarLibros() {
		log.info("Inicio metodo buscarLibros()");

		LibroResponseRest response = new LibroResponseRest();
		
		try {
			
			List<Libro> libro = (List<Libro>) libroDao.findAll();
			response.getLibroResponse().setLibro(libro);
			
			response.setMetadata("Respuesta ok", "00", "Respuesta exitosa");
			
			
		} catch (Exception e) {
			response.setMetadata("Respuesta ok", "-1", "Error al consultar libros");
			log.error("Error al consultar categorias :", e.getMessage());
			e.getStackTrace();
		  return new ResponseEntity<LibroResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	return new ResponseEntity<LibroResponseRest>(response, HttpStatus.OK);
	}

	

    
}
