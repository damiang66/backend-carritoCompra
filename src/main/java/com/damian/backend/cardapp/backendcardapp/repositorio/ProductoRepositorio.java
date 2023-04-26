package com.damian.backend.cardapp.backendcardapp.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damian.backend.cardapp.backendcardapp.entidad.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto,Long>{
    
}
