package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {
		Configuration cfg=new Configuration();
		cfg.configure("cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		
		Question q1=new Question();
		q1.setQuestionId(101);
		q1.setQuestion("what is hibernate?");
		
		Answer answer=new Answer();
		answer.setAnswerId(1013);
		answer.setAnswer("hibernate is a query service for any java application" );
		answer.setQuestion(q1);
		Answer a2=new Answer();
		a2.setAnswerId(1014);
		a2.setAnswer("hibernet is just as jdbc");
		a2.setQuestion(q1);
		
//		q1.setAnswer(answer);
		
//		
//		
//		
//		Question q2=new Question();
//		q2.setQuestionId(102);
//		q2.setQuestion("what is spring?");
//		
//		Answer a2=new Answer();
//		a2.setAnswerId(1012);
//		a2.setAnswer("spring is a framework of java used to make api." );
//		
//		a2.setQuestion(q2);
//	//	q2.setAnswer(a2);
//		
//		
//		Answer a1=new Answer();
//		a1.setAnswerId(1011);
//		a1.setAnswer("spring is java framework that provides infrastructure support for developing java appication." );
//		
//		a1.setQuestion(q2);
		List<Answer> list=new ArrayList<Answer>();
		list.add(answer);
		list.add(a2);
//		
//		
		q1.setAnswer(list);
//		
 		Session session =factory.openSession();
		session.beginTransaction();
//		
//		
//		
		session.save(q1);
		session.save(answer);
		session.save(a2);
//		
		session.getTransaction().commit();
//		
		
//		Question qq=(Question)session.get(Question.class, 102);
//		System.out.println(qq.getQuestion());
//		for(Answer answer1:qq.getAnswer()) {
//			System.out.println(answer1.getAnswer());
//		}
		
		
		
		
		session.close();
		factory.close();
	}

}
