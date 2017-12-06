/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.controller.converter;

import com.montes.bo.ProductoBo;
import com.montes.model.Producto;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
 
@FacesConverter("productoConverter")
public class ProductoConverter implements Converter {
    
    @EJB
    private ProductoBo service;
 
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                //return service.getProductos().get(Integer.parseInt(value));
                com.montes.persistence.entity.Producto prodEntity=service.getById(Integer.parseInt(value));
                Producto prod=new Producto();
                prod.setId(prodEntity.getId());
                prod.setNombre(prodEntity.getNombre());
                prod.setPrecio(prodEntity.getPrecio());
                return prod;
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid producto."));
            }
        }
        else {
            return null;
        }
    }
 
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Producto) object).getId());
        }
        else {
            return null;
        }
    }   
}
