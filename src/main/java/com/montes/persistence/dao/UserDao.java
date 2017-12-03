package com.montes.persistence.dao;

import java.util.List;
import com.montes.persistence.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao{

    private Session session;
    private Transaction tx;

    private void iniciaOperacion() {
        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }

    public void save(User user) {
        try {
            iniciaOperacion();
            session.save(user);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al guardar: " + ex);
        } finally {
            session.close();
        }
    }
    
    public void update(User user) {
        try {
            iniciaOperacion();
            session.update(user);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al actualizar: " + ex);
        } finally {
            session.close();
        }
    }
    
    public void delete(User user){
        try {
            iniciaOperacion();
            session.delete(user);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al actualizar: " + ex);
        } finally {
            session.close();
        }
    }

    public User find(int id){
        User user=null;
        try {
            iniciaOperacion();
            user=(User)session.get(User.class, id);
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al recuperar un user: " + ex);
        } finally {
            session.close();
        }
        return user;
    }
    
    public List<User> getAll(){
        List<User> users=null;
        try {
            iniciaOperacion();
            users=session.createQuery("from User").list();
            tx.commit();
        } catch (HibernateException ex) {
            tx.rollback();
            System.out.println("Error al recuperar los users: " + ex);
        } finally {
            session.close();
        }
        return users;
    }
}
