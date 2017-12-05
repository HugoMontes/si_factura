/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.montes.persistence.dao.HibernateUtil;
import com.montes.persistence.dao.ProductoDao;
import com.montes.persistence.entity.Producto;

/**
 *
 * @author MONTES
 */
public class TestDaoProducto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductoDao productoDao=new ProductoDao();
        for(Producto p: productoDao.getAll()){
            System.out.println(p.getId()+"-"+p.getNombre());
        }
        HibernateUtil.closeSessionFactory();
    }
    
}
