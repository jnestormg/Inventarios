package com.inventarios.inventario.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventarios.inventario.entities.Compras;
import com.inventarios.inventario.repositories.ComprasRepository;

import jakarta.transaction.Transactional;

@Service
public class ComprasService implements IComprasService {


    @Autowired
    private ComprasRepository repository;

    @Override
    public List<Compras> mostrarCompras() {
        return repository.findAll();
    }

    @Override
    public Compras buscarPorId(Long id) {
       return repository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public Compras guardarCompras(Compras compras) {
       return repository.save(compras);
    }

    @Transactional
    @Override
    public void eliminarCompra(Long id) {
        repository.deleteById(id);
    }
    
}
