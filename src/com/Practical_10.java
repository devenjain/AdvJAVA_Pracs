package com;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Practical_10 {

	public static void main(String[] args) {

		Configuration config = new Configuration();

		config.configure("hibernate.cfg.xml");
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		User user = new User();
		user.setuName("Deven");
		user.setuEmail("deven@gmail.com");

		session.save(user);
		tx.commit();

	}

}
