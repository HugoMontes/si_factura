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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;

import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import org.primefaces.event.FlowEvent;

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
    
    private double importe;
    private double totalImporte ;
    private boolean next;
    
    @EJB
    private ProductoBo productoBo;
    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        this.factura = new Factura();
        this.factura.setNro((int)(Math.random()*1000));
        this.factura.setFecha(new Date());
        importe=0;
        totalImporte=0;
        this.detalle=new Detalle();
        producto=new Producto();
        producto.setNombre("");
        this.detalle.setProducto(producto);
        // this.factura.getDetalles().add(new Detalle(new Producto("Mango",Double.parseDouble("15")), 5, Double.parseDouble("150"), null, null));
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

    public double getTotalImporte() {
        return totalImporte;
    }

    public void setTotalImporte(double totalImporte) {
        this.totalImporte = totalImporte;
    }

    public ProductoBo getProductoBo() {
        return productoBo;
    }

    public void setProductoBo(ProductoBo productoBo) {
        this.productoBo = productoBo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }
    

    
    
           
    public List<Producto> completeProducto(String query) {
        //List<Producto> allProductos = service.getProductos();
        List<Producto> productos = new ArrayList<Producto>();
        for (com.montes.persistence.entity.Producto p: productoBo.getAll()) {
            if(p.getNombre().toLowerCase().startsWith(query)) {
                Producto prod=new Producto();
                prod.setId(p.getId());
                prod.setNombre(p.getNombre());
                prod.setPrecio(p.getPrecio());
                productos.add(prod);
            }
        }
         
        return productos;
    }
    
    public void adicionarProducto(ActionEvent actionEvent){
        if(detalle.getCantidad()!=null && detalle.getCantidad()!=0 && detalle.getProducto()!=null){
            detalle.setPrecio(detalle.getProducto().getPrecio());
            totalImporte+=detalle.getPrecio()*detalle.getCantidad();

            factura.getDetalles().add(detalle);
            // Inicializar formulario
            detalle=new Detalle();
            detalle.setProducto(new Producto());
            // Mostrar mensaje
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto agregado exitosamente.",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            // Mostrar mensaje
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Los campos Cantidad y Descripcion son obligatorios.",  null);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
    
    public String onFlowProcess(FlowEvent event) {
        String tabId= event.getNewStep();
        next=true;
        if(tabId.equals("reporte")){
            if(factura.getNit()==null || factura.getNit().equals("")){
                next=false;
                // Mostrar mensaje
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo NIT/CI es obligatorio.",  null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            if(factura.getNombre()==null || factura.getNombre().equals("")){
                next=false;
                // Mostrar mensaje
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El campo Nombre es obligatorio.",  null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
            if(factura.getDetalles()==null || factura.getDetalles().size()==0){
                next=false;
                // Mostrar mensaje
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe ingresar al menos un producto en Detalle.",  null);
                FacesContext.getCurrentInstance().addMessage(null, message);
            }
        }
        if(next){
            return event.getNewStep();
        }else{
            return event.getOldStep();
        }
    }
    
    public void guardar(ActionEvent actionEvent){
        // Mostrar mensaje
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Facturado exitosamente.",  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
