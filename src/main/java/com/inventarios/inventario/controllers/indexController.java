package com.inventarios.inventario.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventarios.inventario.services.ComprasService;
import com.inventarios.inventario.services.ProductosService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;
import com.inventarios.inventario.entities.*;
import java.util.List;

@Component
@ViewScoped
@Data
@Named
public class indexController {

  @Autowired
  ProductosService productosService;

  private static final Logger logger = LoggerFactory.getLogger(indexController.class);

  private List<Productos> listaProductos;

  private List<Productos> listaProductosBusqueda;

  private Productos productoSeleccionado;


  @PostConstruct
  public void init() {
    mostrarProductos();
    mensaje();
  }

  public void mostrarProductos() {
    this.listaProductos = productosService.mostrarProductos();
  }

  public void nuevo(ActionEvent event) {
    this.productoSeleccionado = new Productos();
    System.out.println("nuevo......................");
    logger.info("se crea nuevo producto"+this.productoSeleccionado);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto nuevo"));

  }


  public void mensaje(){
    FacesContext.getCurrentInstance().addMessage(null, 
    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Message", "mesanje"));
  }

  

  public void guardar() {
    logger.info("prodcucto a guardar"+this.productoSeleccionado);
    if(this.productoSeleccionado.getId() ==null){
    this.productosService.guardarProductos(this.productoSeleccionado);
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto agregado"+this.productoSeleccionado));
    System.out.println("guardar......................");
    }
    else{
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto no agregado"));

    }

  }



}
