package com.inventarios.inventario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventarios.inventario.entities.Compras;

@Repository
public interface ComprasRepository extends JpaRepository<Compras, Long> {
    
}
