/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author MONTES
 */
public class Detalle implements Serializable{

    private Integer id;
    private Factura factura;
    private Producto producto;
    private Integer cantidad;
    private Double precio;
    private Date createdAt;
    private Date updatedAt;

    public Detalle() {
        producto=new Producto();
    }

    public Detalle(Producto producto, Integer cantidad, Double precio, Date createdAt, Date updatedAt) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
