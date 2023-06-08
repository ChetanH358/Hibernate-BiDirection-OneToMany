package com.zt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveHospital {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("chetan");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Hospital hospital_1 = new Hospital();
		hospital_1.setName("KLE");
		hospital_1.setWebsite("kle.multispacilityhospital.com");
		hospital_1.setPhno(8534129670l);

		Hospital hospital_2 = new Hospital();
		hospital_2.setName("SDM");
		hospital_2.setWebsite("sdm.multispacilityhospital.com");
		hospital_2.setPhno(8534129680l);

		Hospital hospital_3 = new Hospital();
		hospital_3.setName("KIMS");
		hospital_3.setWebsite("kimshubli.govthospital.com");
		hospital_3.setPhno(8534129690l);

		Branchs branchs_1 = new Branchs();
		branchs_1.setName("cancer hospital");
		branchs_1.setState("Belgavi");
		branchs_1.setStreet("vadgov");
		branchs_1.setPhno(9574137440l);

		Branchs branchs_2 = new Branchs();
		branchs_2.setName("heart hospital");
		branchs_2.setState("Belgavi");
		branchs_2.setStreet("near chennamma circle");
		branchs_2.setPhno(9574137450l);

		Branchs branchs_3 = new Branchs();
		branchs_3.setName("brain surgery hospital");
		branchs_3.setState("hubballi");
		branchs_3.setStreet("gokul road");
		branchs_3.setPhno(9574137460l);

		Branchs branchs_4 = new Branchs();
		branchs_4.setName("kidney hospital");
		branchs_4.setState("hubballi");
		branchs_4.setStreet("unkal village");
		branchs_4.setPhno(9574137470l);

		Branchs branchs_5 = new Branchs();
		branchs_5.setName("ankel and knee surgery");
		branchs_5.setState("vijapur");
		branchs_5.setStreet("samudayabhavan");
		branchs_5.setPhno(9574137480l);

		Branchs branchs_6 = new Branchs();
		branchs_6.setName("tooth and eye surgery");
		branchs_6.setState("vijapur");
		branchs_6.setStreet("central railway sataion");
		branchs_6.setPhno(9574137490l);

		List<Branchs> list_1 = new ArrayList<Branchs>();
		list_1.add(branchs_1);
		list_1.add(branchs_2);

		List<Branchs> list_2 = new ArrayList<Branchs>();
		list_2.add(branchs_3);
		list_2.add(branchs_4);

		List<Branchs> list_3 = new ArrayList<Branchs>();
		list_3.add(branchs_5);
		list_3.add(branchs_6);

		hospital_1.setBranchs(list_1);
		hospital_2.setBranchs(list_2);
		hospital_3.setBranchs(list_3);

		branchs_1.setHospital(hospital_1);
		branchs_2.setHospital(hospital_1);
		branchs_3.setHospital(hospital_2);
		branchs_4.setHospital(hospital_2);
		branchs_5.setHospital(hospital_3);
		branchs_6.setHospital(hospital_3);

		entityTransaction.begin();
		entityManager.persist(hospital_1);
		entityManager.persist(hospital_2);
		entityManager.persist(hospital_3);
		entityManager.persist(branchs_1);
		entityManager.persist(branchs_2);
		entityManager.persist(branchs_3);
		entityManager.persist(branchs_4);
		entityManager.persist(branchs_5);
		entityManager.persist(branchs_6);
		entityTransaction.commit();

	}

}
