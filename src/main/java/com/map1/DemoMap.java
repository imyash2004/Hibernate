package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.map.Question;

public class DemoMap {

	public static void main(String[] args) {
		Configuration  cfg= new Configuration();
        cfg.configure("cfg.xml");
        SessionFactory factory =cfg.buildSessionFactory();
        Session session =factory.openSession();
        
        
//        //creating obj
//        Emp e1=new Emp();
//        Emp e2=new Emp();
//        e1.setEid(34);
//        e1.setName("Ram");
//        e2.setEid(35);
//        e2.setName("Shyam");
//        
//        Project p1=new Project();
//        Project p2=new Project();
//        p1.setPid(121);
//        p1.setProjectName("Library Management System");
//        p2.setPid(122);
//        p2.setProjectName("Railway Reservation system");
//        
//        
//        
//        List<Project> l2=new ArrayList<Project>();
//        List<Emp> l1=new ArrayList<Emp>();
//        l1.add(e2);
//        l1.add(e1);
//        l2.add(p2);
//        l2.add(p1);
//        e1.setProjects(l2);
//        p2.setEmps(l1);
//        
//        
//        
//        session.beginTransaction();
//        session.save(e1);
//        session.save(e2);
//        session.save(p1);
//        session.save(p2);
//        session.getTransaction().commit();
       
        
        session.close();
        factory.close();

	}

}
