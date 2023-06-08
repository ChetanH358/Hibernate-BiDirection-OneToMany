package com.zt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteByBranch {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

//		if we wnat to delete branches we have to find all branches releated to it and delete it 
//		all three got deleted 
//		Branch 1 -> cancer hospital| belgavi| vadgov | 9574137440
//		Branch 2 -> heart hospital | belgavi | near chennamma circle | 9574137450
//		Hospital 1 -> KLE | kle.multispacilityhospital.com | 8534129670

//		Branchs branch_1 = entityManager.find(Branchs.class, 1);
//		Branchs branch_2 = entityManager.find(Branchs.class, 2);
//		Hospital hospital_1 = entityManager.find(Hospital.class, 1);

//		if we attempting to delete (id) which is not present in data-base it will give "Data Not Found"

//		if (branch_1 != null) {
//			entityTransaction.begin();
//			entityManager.remove(branch_1);
//			entityManager.remove(branch_2);
//			entityManager.remove(hospital_1);
//			System.out.println("data deleted");
//			entityTransaction.commit();
//
//		} else {
//			System.out.println("Data Not Found !");
//		}

//		***************************************************************************************************

//		code is working correctly 
//		Query query_branchs = entityManager.createQuery("select b from Branchs b");
//		List<Branchs> list_branchs = query_branchs.getResultList();
//		
//		entityTransaction.begin();
//		int hospital_id = 0;
//		for (Branchs branchs_ele : list_branchs) {
//			if(branchs_ele.getName().equals("cancer hospital") || branchs_ele.getName().equals("heart hospital")) {
//				entityManager.remove(branchs_ele);
//				Hospital h = branchs_ele.getHospital();
//				hospital_id = h.getId();	
//			}	
//		}
//		Query query_hospital = entityManager.createQuery("select h from Hospital h where h.id =?1");
//		query_hospital.setParameter(1, hospital_id);
//		List<Hospital> list_hospital = query_hospital.getResultList();
//		
//		for (Hospital hospital_ele : list_hospital) {
//			entityManager.remove(hospital_ele);
//		}
//		entityTransaction.commit();
//		System.out.println("data deleted successfully !");

//		***************************************************************************************************
		
//		code is working correctly and note : while writing query we can use special operators from sql --> in,betwen,like etc;....

//		Query query_branchs = entityManager.createQuery("select b from Branchs b where b.name in (?1,?2)");
//		query_branchs.setParameter(1, "brain surgery hospital");
//		query_branchs.setParameter(2, "kidney hospital");
//		List<Branchs> list_branchs = query_branchs.getResultList();
//		
//		entityTransaction.begin();
//		int hospital_id = 0;
//		for (Branchs branchs_ele : list_branchs) {
//				entityManager.remove(branchs_ele);
//				Hospital h = branchs_ele.getHospital();
//				hospital_id = h.getId();	
//		
//		}
//		Query query_hospital = entityManager.createQuery("select h from Hospital h where h.id =?1");
//		query_hospital.setParameter(1, hospital_id);
//		List<Hospital> list_hospital = query_hospital.getResultList();
//		
//		for (Hospital hospital_ele : list_hospital) {
//			entityManager.remove(hospital_ele);
//		}
//		entityTransaction.commit();
//		System.out.println("data deleted successfully !");

	}

}
