/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.montes.persistence.dao.HibernateUtil;
import com.montes.persistence.dao.UserDao;
import com.montes.persistence.entity.User;

/**
 *
 * @author MONTES
 */
public class TestDaoUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        User user=new User();
        user.setName("Juan Perez");
        user.setEmail("juan@gmail.com");
        user.setPassword("123456");
        UserDao userDao=new UserDao();
        userDao.save(user);
        HibernateUtil.closeSessionFactory();
    }
    
}
