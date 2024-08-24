package com.inventarios.inventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventarios.inventario.entities.Productos;
import com.inventarios.inventario.repositories.ProductosRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductosService implements IProductoService {

    @Autowired
    private ProductosRepository repository;

    @Override
    public List<Productos> mostrarProductos() {
       return repository.findAll();
    }

    @Override
    public Productos buscarProductosPorId(Long id) {
     return repository.findById(id).orElse(null); 
    }

    @Transactional
    @Override
    public Productos guardarProductos(Productos productos) {
       return repository.save(productos);
    }

    @Transactional
    @Override
    public void eliminarProductos(Long id) {
        repository.deleteById(id);
    }
}
