package com.hql;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.query.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class HQLExample {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		//HQL
		//SYNTAX
		
		Session s= factory.openSession();
//		String query="from Student";
	//	String query="from Student where city=:x";
		String query="from Student as s where s.city=:x or s.name=:y";

		Query<Student> q=s.createQuery(query);
		q.setParameter("x", "delhi");
    	q.setParameter("y", "sandeep agarwal");
    	
    	
    	
		
		
		
		//single or multiple
		List<Student> list=q.list();
		for(Student ss:list) {
			System.out.println(ss );
		}
		System.out.println("------------------------------------------------------");
		s.beginTransaction();
//		Query q1=s.createQuery("delete from Student as s where s.id=:a");
//		q1.setParameter("a",102);
//		int r=q1.executeUpdate();
//		System.out.println("NIAKL BHAAG YHA SAI.............");
//		System.out.println(r);
//		s.getTransaction().commit();
		Query q2=s.createQuery("update Student set certi.course='python', certi.duration='2 months' where id=:a");
		q2.setParameter("a", 101);
		int r=q2.executeUpdate();
		System.out.println("hn kr diya update ab ja yha sai .....");
		System.out.println(r);
		s.getTransaction().commit();
		
		
		//executing join query............................
		Query q3=s.createQuery("select q.question,q.questionId,a.answer from question12 as q INNER JOIN q.answer as a");
		List<Object []> list3=q3.getResultList();
		for(Object[] l3:list3) {
			System.out.println(Arrays.toString(l3));
		}
		s.close();
		factory.close();
	}

}
