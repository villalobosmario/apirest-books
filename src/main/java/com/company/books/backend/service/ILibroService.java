package com.company.books.backend.service;

import org.springframework.http.ResponseEntity;

import com.company.books.backend.model.Categoria;
import com.company.books.backend.response.CategoriaResponseRest;
import com.company.books.backend.response.LibroResponseRest;

public interface ILibroService {
    public ResponseEntity<LibroResponseRest> buscarLibros();
    
}
