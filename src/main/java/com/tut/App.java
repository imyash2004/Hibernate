package com.tut;


import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration  cfg= new Configuration();
        cfg.configure("cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        
        Student s1=new Student();
        s1.setId(103);
        s1.setName("vaibhav agarwal");
        s1.setCity("bangalore");
        
        
        
        System.out.println(s1);
        
        Address ad=new Address();
        ad.setStreet("street2");
        ad.setCity("bangalore");
        ad.setOpen(true);
        ad.setAddeddate(new Date());
        ad.setX(123.3323);
        
        
        //reading image
        FileInputStream fis=new FileInputStream("src/main/java/IMG20220903172055.jpg");
        byte[] data= new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        System.out.println(ad );
        
        Session session=factory.openSession();
        session.beginTransaction();
        session.save(s1);
        session.save(ad);
        session.getTransaction().commit();
        session.close();
        System.out.println("DONE....................");
        
    }
}
