package com;

import com.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


/**
 * Created by Administrator on 2017/3/4.
 */
public class Demo {
    private Configuration con;
    private SessionFactory sf;
    private Session session;
    @Before
    public void init(){
        con=new Configuration().configure();
        sf=con.buildSessionFactory();
        session=sf.openSession();
        session.beginTransaction();
    }
    @Test
    public void save(){
        User u1=new User(0,"ss");
        User u2=new User(3,"ss");
        session.save(u1);
        session.save(u2);
    }
    @Test
    public void test(){
        List<User> lu=session.createQuery("select name from User").list();
        for (User u : lu) {
            System.out.println(u.getName());
        }
    }

    @After
    public void close(){
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}
