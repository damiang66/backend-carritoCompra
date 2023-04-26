package com.damian.backend.cardapp.backendcardapp.controlador;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damian.backend.cardapp.backendcardapp.entidad.Producto;
import com.damian.backend.cardapp.backendcardapp.services.ProductoService;
@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/productos")
public class ProductoControlador {
    @Autowired
    private ProductoService service;
    /**
     * @param result
     * @return
     */
    private ResponseEntity<?> validar(BindingResult bindingResult){
        Map<String,Object> errores = new HashMap<>();
        bindingResult.getFieldErrors().forEach(e->{
            errores.put(e.getField(), "el campo" +e.getField()+ " "+ e.getDefaultMessage());
        });
        return new ResponseEntity<>(errores,HttpStatus.NOT_FOUND);
    }
    @GetMapping
    public ResponseEntity<?>listar(){
        return ResponseEntity.ok().body(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>verUno(@PathVariable Long id){
        Optional<Producto> r = service.findById(id);
        if (r.isPresent()){
           return ResponseEntity.ok().body(r.get()); 
        }
        return ResponseEntity.notFound().build();
    }

    
}
