package com.damian.backend.cardapp.backendcardapp.services;

import java.util.List;
import java.util.Optional;

import com.damian.backend.cardapp.backendcardapp.entidad.Producto;

public interface ProductoService {
    public List<Producto> findAll();
    public Optional<Producto>findById(Long id);
    public Producto save(Producto producto);
    public void delete(Long id);
    
}
