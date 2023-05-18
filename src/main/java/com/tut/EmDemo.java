package com.tut;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration  cfg= new Configuration();
        cfg.configure("cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Student s1=new Student();
        s1.setId(1234);
        s1.setName("yash");
        s1.setCity("delhi");
        Certificate c1=new Certificate();
        c1.setCourse("hibernate");
        c1.setduration("2 years");
        s1.setCerti(c1);
        
        
        
        
        
        Student s2=new Student();
        s2.setId(12342);
        s2.setName("yash");
        s2.setCity("delhi");
        Certificate c2=new Certificate();
        c2.setCourse("mvc");
        c2.setduration("2 months");
        s2.setCerti(c2);
        
        Session session=factory.openSession();
        session.beginTransaction();
        session.save(s1);
        session.save(s2);
        session.getTransaction().commit();
        
        
        
        
        factory.close();

	}

}
