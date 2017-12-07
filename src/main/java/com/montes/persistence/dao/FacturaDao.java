package com.montes.persistence.dao;

import java.util.List;
import com.montes.persistence.entity.Factura;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FacturaDao{

    private Session session;
    private Transaction tx;

    private void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public void save(Factura factura) {
        try {
            iniciaOperacion();
            session.save(factura);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al guardar: " + ex);
        } finally {
            session.close();
        }
    }
    
    public void update(Factura factura) {
        try {
            iniciaOperacion();
            session.update(factura);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al actualizar: " + ex);
        } finally {
            session.close();
        }
    }
    
    public void delete(Factura factura){
        try {
            iniciaOperacion();
            session.delete(factura);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al actualizar: " + ex);
        } finally {
            session.close();
        }
    }

    public Factura find(int id){
        Factura factura=null;
        try {
            iniciaOperacion();
            factura=(Factura)session.get(Factura.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al recuperar un factura: " + ex);
        } finally {
            session.close();
        }
        return factura;
    }
    
    public List<Factura> getAll(){
        List<Factura> facturas=null;
        try {
            iniciaOperacion();
            facturas=session.createQuery("from Factura").list();
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al recuperar los facturas: " + ex);
        } finally {
            session.close();
        }
        return facturas;
    }
}
