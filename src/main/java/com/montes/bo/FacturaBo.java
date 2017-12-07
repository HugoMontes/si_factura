/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.montes.bo;

import com.montes.model.Factura;
import javax.ejb.Local;

/**
 *
 * @author Hugo
 */
@Local
public interface FacturaBo {
    public void save(Factura factura);
}
