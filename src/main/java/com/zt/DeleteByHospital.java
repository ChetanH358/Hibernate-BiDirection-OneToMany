package com.zt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteByHospital {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

/*		we cannot delete the hospital directly getting exception (cannot update or delete parent row) 
*		because of Bi-direction Mapping .
*		if we want to delete details of parent table , we need to search and delete corresponding child classes as well
*		if we want to delete hospital_1 then first we need to find 
*		branches corresponding to the hospital_1 , then only able to delete parent table (hospital_1)
*/		
		
//		Hospital hospital_2 = entityManager.find(Hospital.class, 2);
//		if (hospital_2 != null) {
//			entityTransaction.begin();
//			entityManager.remove(hospital_2);
//			System.out.println("data deleted");
//			entityTransaction.commit();
//
//		} else {
//			System.out.println("Data Not Found !");
//		}
		
		
/*		we cannot delete hospital directly because as it is bi-direction we need to find the corresponding branches relating
 *  	to the hospital_1 class  
 */
		
//		this approach worked out
//		Hospital hospital_2 = entityManager.find(Hospital.class, 2);
//		Branchs branch_3 = entityManager.find(Branchs.class, 3);
//		Branchs branch_4 = entityManager.find(Branchs.class, 4);

//		if we attempting to delete (id) which is not present in data-base it will give "Data Not Found"
		
//		if (hospital_2 != null) {
//			entityTransaction.begin();
//			entityManager.remove(hospital_2);
//			entityManager.remove(branch_3);
//			entityManager.remove(branch_4);
//			System.out.println("data deleted");
//			entityTransaction.commit();
//
//		} else {
//			System.out.println("Data Not Found !");
//		}

//		*********************************************************************************************************
		Query query_hospital = entityManager.createQuery("select h from Hospital h where h.name = ?1");
		query_hospital.setParameter(1, "SDM");
		List<Hospital> list_hospital = query_hospital.getResultList();
		
		for (Hospital hospital_ele : list_hospital) {
			Query query_branchs = entityManager.createQuery("select b from Branchs b where hospital.id =?1");
			query_branchs.setParameter(1, hospital_ele.getId());
			List<Branchs> list_branches = query_branchs.getResultList();
			
			entityTransaction.begin();
			for (Branchs branch_ele : list_branches) {
				entityManager.remove(branch_ele);
			}
			entityManager.remove(hospital_ele);
			entityTransaction.commit();
			
		}
		System.out.println("data deleted successfully !");
		
	
	}

}
