/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.controller;

import com.montes.model.Detalle;
import com.montes.model.Factura;
import com.montes.model.Producto;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author MONTES
 */
@Named(value = "facturaBean")
@RequestScoped
public class FacturaBean {
    
    private Factura factura;
    private Detalle detalle;
    private Producto producto;
    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        this.factura = new Factura();
        this.detalle=new Detalle();
        this.producto=new Producto();
        this.factura.getDetalles().add(new Detalle(new Producto("Mango",Double.parseDouble("15")), 5, Double.parseDouble("150"), null, null));
    }
    
    @PostConstruct
    public void init() {
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void adicionarProducto(){
        
    }
}
