package com.fjcasasaltas.training.jee.jpa.business;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.fjcasasaltas.training.jee.jpa.domain.CustCustomer;
import com.fjcasasaltas.training.jee.jpa.domain.SecUser;
import com.fjcasasaltas.training.jee.jpa.domain.SysLanguage;
import com.fjcasasaltas.training.jee.jpa.domain.SysLanguageLang;
import com.fjcasasaltas.training.jee.jpa.domain.SysPerson;


@Local(MyServiceLocal.class)
@Remote(MyServiceRemote.class)
@Stateless
public class MyService implements MyServiceLocal {

	@PersistenceContext(unitName = "EXAMPLE")
	private EntityManager em;
	
	@Override
	public String executeQueries() {
		StringBuilder sbResult = new StringBuilder();
		TypedQuery<SysLanguage> q1 = this.em.createQuery("select e from SysLanguage e", SysLanguage.class);
		List<SysLanguage> sysLanguages = q1.getResultList();
		sbResult.append("System Languages\n");
		for (SysLanguage sysLanguage : sysLanguages) {
			StringBuilder sb = new StringBuilder();
			for (SysLanguageLang sysLanguageLang : sysLanguage.getSysLanguageLangs()) {
				if (sb.length() > 0) {
					sb.append(", ");
				}
				sb.append(sysLanguageLang.getName());
			}
			sbResult.append(String.format("%s (%s)\n", sysLanguage.getCode(), sb.toString()));
		}

		TypedQuery<SysPerson> q2 = this.em.createQuery("select e from SysPerson e", SysPerson.class);
		List<SysPerson> sysPersons = q2.getResultList();
		sbResult.append("System Persons\n");
		for (SysPerson sysPerson : sysPersons) {
			StringBuilder sb = new StringBuilder();
			if (sysPerson instanceof CustCustomer) {
				sb.append("Customer:");
			} else if (sysPerson instanceof SecUser) {
				sb.append("User:");
			}
			sb.append(" ");
			sb.append(sysPerson.getSysPersonData().getName());
			sb.append(" ");
			sb.append(sysPerson.getSysPersonData().getLastName());
			sbResult.append(sb.toString()).append('\n');
		}
		
		return sbResult.toString();
	}

}
