package com.company.books.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.response.CategoriaResponseRest;
import com.company.books.backend.response.LibroResponseRest;
import com.company.books.backend.service.ICategoriaService;
import com.company.books.backend.service.ILibroService;

@RestController
@RequestMapping("/v1")
public class LibroRestController {
   @Autowired
	private ILibroService service;
   
   @GetMapping("/libros")
   public ResponseEntity<LibroResponseRest> consultaLibros() {
	  ResponseEntity<LibroResponseRest> response = service.buscarLibros();
	  return response;
   }  
 
}
