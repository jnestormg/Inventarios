package com.inventarios.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventarios.inventario.entities.Ventas;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long>{
    
}
