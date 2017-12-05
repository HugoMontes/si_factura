/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.controller;

import com.montes.bo.ProductoBo;
import com.montes.model.Detalle;
import com.montes.model.Factura;
import com.montes.model.Producto;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;

/**
 *
 * @author MONTES
 */
@Named(value = "facturaBean")
@ViewScoped
public class FacturaBean implements Serializable{
    
    private Factura factura;
    private Detalle detalle;
    private Producto producto;
    
    @EJB
    private ProductoBo productoBo;
    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        this.factura = new Factura();
        this.factura.setNro((int)(Math.random()*1000));
        this.factura.setFecha(new Date());
        this.detalle=new Detalle();
        this.detalle.setProducto(new Producto());
        this.factura.getDetalles().add(new Detalle(new Producto("Mango",Double.parseDouble("15")), 5, Double.parseDouble("150"), null, null));
    }
    
    @PostConstruct
    public void init() {
        /*
        for(com.montes.persistence.entity.Producto p: productoBo.getAll()){
            System.out.println(p.getId()+"-"+p.getNombre());
        }
        */
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
    
    public void adicionarProducto(ActionEvent actionEvent){
        detalle.setPrecio(detalle.getProducto().getPrecio());
        factura.getDetalles().add(detalle);
        detalle=new Detalle();
        detalle.setProducto(new Producto());
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Productor agregado exitosamente.",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
