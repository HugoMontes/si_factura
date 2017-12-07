/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.bo.impl;

import com.montes.bo.FacturaBo;
import com.montes.model.Detalle;
import com.montes.model.Factura;
import com.montes.persistence.dao.FacturaDao;
import com.montes.persistence.dao.ProductoDao;
import com.montes.persistence.entity.User;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author MONTES
 */
@Stateless
public class FacturaBoImpl implements FacturaBo{

    private final FacturaDao facturaDao=new FacturaDao();
    private final ProductoDao productoDao=new ProductoDao();
    
    @Override
    public void save(Factura factura) {
        com.montes.persistence.entity.Factura facturaEntity=new com.montes.persistence.entity.Factura();
        // factura
        facturaEntity.setNro(factura.getNro());
        facturaEntity.setNit(factura.getNit());
        facturaEntity.setNombre(factura.getNombre());
        facturaEntity.setFecha(factura.getFecha());
        facturaEntity.setTotalNum(factura.getTotalNum());
        User user=new User();
        user.setId(1);
        facturaEntity.setUser(user);
        facturaEntity.setCreatedAt(new Date());
        // detalles
        for(Detalle d: factura.getDetalles()){
            com.montes.persistence.entity.Detalle detalleEntity = new com.montes.persistence.entity.Detalle();
            detalleEntity.setCantidad(d.getCantidad());
            detalleEntity.setPrecio(d.getPrecio());
            detalleEntity.setCreatedAt(new Date());
            //Producto
            com.montes.persistence.entity.Producto productoEntity =new com.montes.persistence.entity.Producto();
            productoEntity.setId(d.getProducto().getId());
            detalleEntity.setProducto(productoEntity);
            //detalleEntity.setProducto(productoDao.find(d.getProducto().getId()));
            detalleEntity.setFactura(facturaEntity);
            //System.out.println("-------------------"+d.getProducto().getId());
            facturaEntity.getDetalles().add(detalleEntity);
        }
        facturaDao.save(facturaEntity);
    }
    
}
