package com.inventarios.inventario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventarios.inventario.services.ProductosService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import com.inventarios.inventario.entities.*;
import java.util.List;

@Component
@Data
@ViewScoped
@Named(value = "indexController")
public class indexController {
    
    @Autowired
    ProductosService productosService;

    private List<Productos> listaProductos;

    @PostConstruct
    public void init(){
        mostrarProductos();
    }

    public void mostrarProductos(){
      listaProductos=  productosService.mostrarProductos();
    }
}
