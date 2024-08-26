package com.inventarios.inventario.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventarios.inventario.entities.Compras;
import com.inventarios.inventario.entities.Productos;
import com.inventarios.inventario.services.ComprasService;
import com.inventarios.inventario.services.ProductosService;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ActionEvent;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

@Component
@Data
@ViewScoped
@Named(value = "comprasController")
public class ComprasController {

    @Autowired
    ComprasService comprasService;

    @Autowired
    ProductosService productosService;

    private List<Compras> listaCompras;

    private List<Compras> listaComprasBusqueda;


    private Productos productoSeleccionado;

    private Compras compra;
   
    private static final Logger logger= LoggerFactory.getLogger(indexController.class);


    @PostConstruct
    public void init(){
        mostrarCompras();
    }

    public void mostrarCompras() {
        this.listaCompras = comprasService.mostrarCompras();
    }

    public void nuevo(ActionEvent event) {
    this.productoSeleccionado = new Productos();
    this.compra= new Compras();
    this.listaCompras= null;
    System.out.println("nuevo......................");
    logger.info("se crea nuevo producto"+this.productoSeleccionado);

    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Compra nuevo"));

  }


  public void mensaje(){
    FacesContext.getCurrentInstance().addMessage(null, 
    new FacesMessage(FacesMessage.SEVERITY_INFO, "Info Message", "mesanje"));
  }

  

  public void guardar() {
    logger.info("prodcucto a guardar"+this.productoSeleccionado);
    if(this.productoSeleccionado.getId() ==null){
    this.productosService.guardarProductos(this.productoSeleccionado);
    this.compra.setFecha_ingreso(compra.getFecha_ingreso());
    this.compra.setCantidad(productoSeleccionado.getCantidad());
    this.compra.setProductos(productoSeleccionado);
    this.comprasService.guardarCompras(compra);
 
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto agregado"+this.productoSeleccionado));
    System.out.println("guardar......................");
    }
    else{
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Producto no agregado"));

    }
    this.productoSeleccionado= null;
    mostrarCompras();

  }

}
