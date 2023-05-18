package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// get,load
		Configuration  cfg= new Configuration();
        cfg.configure("cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Session session =factory.openSession();
        //get student with id -102
        
        Student student= session.get(Student.class, 101);
        System.out.println(student);
        Address address=session.get(Address.class, 1);
        session.close();
        System.out.println(address.getStreet());
        factory.close();
		
	}

}
