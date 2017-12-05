/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.bo;

import com.montes.persistence.entity.Producto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Hugo
 */
@Local
public interface ProductoBo {
    public List<Producto> getAll(); 
}
