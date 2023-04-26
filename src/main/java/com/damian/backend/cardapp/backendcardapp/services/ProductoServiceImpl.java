package com.damian.backend.cardapp.backendcardapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damian.backend.cardapp.backendcardapp.entidad.Producto;
import com.damian.backend.cardapp.backendcardapp.repositorio.ProductoRepositorio;
@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepositorio repositorio;

    @Override
    public List<Producto> findAll() {
     return repositorio.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
       return repositorio.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
    return repositorio.save(producto);
    }

    @Override
    public void delete(Long id) {
    repositorio.deleteById(id);
    }
    
}
