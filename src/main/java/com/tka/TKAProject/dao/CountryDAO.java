package com.tka.TKAProject.dao;

import java.util.List; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.TKAProject.entity.Country;


@Repository
public class CountryDAO {
	
	@Autowired
	SessionFactory factory;

	public String addCountry(Country country) {
		// TODO Auto-generated method stub
		
		Session session = null;
		Transaction transaction = null;
		String message = null;
		try {
			session = factory.openSession();
			transaction=session.beginTransaction();
			session.persist(country);
			transaction.commit();
			message = "Country Added Successfully...";
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		
		
		return message;
	}

	public String updateCountry(Country country, int cId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		String message = null;
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			Country c = session.get(Country.class, cId);
			c.setcname(country.getcname());
			session.merge(c);
			transaction.commit();
			message = "Country is updated Successfully";
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return message;
	}

	public String deleteCountry(int cId) {
		
		Session session = null;
		Transaction transaction = null;
		String message = null;
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			Country country = session.get(Country.class, cId);
			session.remove(country);
			transaction.commit();
			message = "Country deleted Successfully";
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
			
		}
		
		
		return message;
	}

	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		List<Country> list=null;
		try {
			
			session = factory.openSession();
			transaction = session.beginTransaction();
			String hqlQuery = "from Country";
			Query<Country> query = session.createQuery(hqlQuery,Country.class);
			list = query.list();
			transaction.commit();
			
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return list;
	}

	public Country getParticularCountry(int cId) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction transaction = null;
		Country country = null;
		try{
			session = factory.openSession();
			transaction = session.beginTransaction();
			country = session.get(Country.class, cId);
			transaction.commit();
			
		}catch(Exception e) {
			if(transaction!=null)
				transaction.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		return country;
	}
	
}
