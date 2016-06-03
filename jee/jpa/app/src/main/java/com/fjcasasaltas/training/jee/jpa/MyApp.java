package com.fjcasasaltas.training.jee.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.fjcasasaltas.training.jee.jpa.domain.CustCustomer;
import com.fjcasasaltas.training.jee.jpa.domain.SecUser;
import com.fjcasasaltas.training.jee.jpa.domain.SysLanguage;
import com.fjcasasaltas.training.jee.jpa.domain.SysLanguageLang;
import com.fjcasasaltas.training.jee.jpa.domain.SysPerson;
import com.fjcasasaltas.training.jee.jpa.domain.SysPersonData;

public class MyApp {

	public static void main(String[] args) {

		EntityManagerFactory emf = null;
		EntityManager em = null;
		try {
			emf = Persistence.createEntityManagerFactory("EXAMPLE");
			em = emf.createEntityManager();

			TypedQuery<SysLanguage> q1 = em.createQuery("select e from SysLanguage e", SysLanguage.class);
			List<SysLanguage> sysLanguages = q1.getResultList();
			System.out.println("System Languages");
			for (SysLanguage sysLanguage : sysLanguages) {
				StringBuilder sb = new StringBuilder();
				for (SysLanguageLang sysLanguageLang : sysLanguage.getSysLanguageLangs()) {
					if (sb.length() > 0) {
						sb.append(", ");
					}
					sb.append(sysLanguageLang.getName());
				}
				System.out.println(String.format("%s (%s)", sysLanguage.getCode(), sb.toString()));
			}

			TypedQuery<SysPersonData> q2 = em.createQuery("select e from SysPersonData e", SysPersonData.class);
			List<SysPersonData> sysPersonDatas = q2.getResultList();
			System.out.println("System Persons");
			for (SysPersonData sysPersonData : sysPersonDatas) {
				SysPerson sysPerson = sysPersonData.getSysPerson();
				StringBuilder sb = new StringBuilder();
				if (sysPerson instanceof CustCustomer) {
					sb.append("Customer:");
				} else if (sysPerson instanceof SecUser) {
					sb.append("User:");
				}
				sb.append(" ");
				sb.append(sysPersonData.getName());
				sb.append(" ");
				sb.append(sysPersonData.getLastName());
				System.out.println(sb.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (em != null) {
				em.close();
			}
			if (emf != null) {
				emf.close();
			}
		}

	}

}
