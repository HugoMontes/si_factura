/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.bo.impl;

import com.montes.bo.ProductoBo;
import com.montes.persistence.dao.ProductoDao;
import com.montes.persistence.entity.Producto;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Hugo
 */
@Stateless
public class ProductoBoImpl implements ProductoBo{

    private final ProductoDao productoDao=new ProductoDao();
    
    @Override
    public List<Producto> getAll() {
        return productoDao.getAll();
    }
    
}
