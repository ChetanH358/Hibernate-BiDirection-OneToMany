package com.zt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetAllByHospital {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Query query = entityManager.createQuery("select h from Hospital h");
		List<Hospital> hospitals = query.getResultList();

		for (Hospital hospital : hospitals) {
			System.out.println("***************************************************");
			System.out.println("Hospital ID = " + hospital.getId());
			System.out.println("Hospital Name = " + hospital.getName());
			System.out.println("Hospital Website = " + hospital.getWebsite());
			System.out.println("Hospital PhNo = " + hospital.getPhno());
			System.out.println("***************************************************");
		}
	}

}
