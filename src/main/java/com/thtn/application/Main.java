package com.thtn.application;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.thtn.domain.Employee;

public class Main {
	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		log.info("Testing log");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
		EntityManager em = emf.createEntityManager();

		Employee thien = new Employee("thien", "Nguyen");
		em.getTransaction().begin();
		em.persist(thien);
		em.getTransaction().commit();

		System.out.println("Retrieving...");
		System.out.println(em.find(Employee.class, 1L));

		em.close();
		emf.close();

	}
}
