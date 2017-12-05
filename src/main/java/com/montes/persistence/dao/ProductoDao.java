package com.montes.persistence.dao;

import java.util.List;
import com.montes.persistence.entity.Producto;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProductoDao{

    private Session session;
    private Transaction tx;

    private void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public void save(Producto producto) {
        try {
            iniciaOperacion();
            session.save(producto);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al guardar: " + ex);
        } finally {
            session.close();
        }
    }
    
    public void update(Producto producto) {
        try {
            iniciaOperacion();
            session.update(producto);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al actualizar: " + ex);
        } finally {
            session.close();
        }
    }
    
    public void delete(Producto producto){
        try {
            iniciaOperacion();
            session.delete(producto);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al actualizar: " + ex);
        } finally {
            session.close();
        }
    }

    public Producto find(int id){
        Producto producto=null;
        try {
            iniciaOperacion();
            producto=(Producto)session.get(Producto.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al recuperar un producto: " + ex);
        } finally {
            session.close();
        }
        return producto;
    }
    
    public List<Producto> getAll(){
        List<Producto> productos=null;
        try {
            iniciaOperacion();
            productos=session.createQuery("from Producto").list();
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al recuperar los productos: " + ex);
        } finally {
            session.close();
        }
        return productos;
    }
}
