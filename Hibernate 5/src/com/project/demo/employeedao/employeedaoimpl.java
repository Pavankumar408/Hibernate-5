package com.project.demo.employeedao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.project.demo.employee;
import com.project.employee.util.sessionfactoryprovider;

public class employeedaoimpl implements employeedao {

	
	public void getsalary(int slno) {
		System.out.println("employeedaoimpl.getsalary()");
		SessionFactory sessionFactory=null;
		Session session=null;
		try {
			sessionFactory=sessionfactoryprovider.getsessionfactory();
			session=sessionFactory.openSession();
			String hqlquery="select name from employee where slno=:sl_no";
			Query query=session.createQuery(hqlquery);
			query.setParameter("sl_no", slno);
			Object obj=query.uniqueResult();
			System.out.println("name is ="+obj);
			String name=(String) obj;
			System.out.println(name);
		}
		catch(HibernateException e) {
			System.out.println(e.getMessage());
		}
		
			
		 finally {
			 if(session!=null) {
				 System.out.println("session is closed");
				 session.close();
			 }
			 else {
				 System.out.println("session is not closed");
			 }
			 sessionfactoryprovider.closesessionfactory();
		}
	}

}