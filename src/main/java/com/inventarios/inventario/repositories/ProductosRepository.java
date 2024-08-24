package com.inventarios.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventarios.inventario.entities.Productos;

@Repository
public interface ProductosRepository extends JpaRepository<Productos, Long> {
    
}
