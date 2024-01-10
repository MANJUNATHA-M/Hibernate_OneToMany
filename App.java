package com.hibernate.onetomany.mapping.OneToManyMap;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
	public static void main( String[] args )
	{

		Person p1=new Person();
		p1.setpId(1);
		p1.setpName("Deeksha");
		p1.setpContact(709006571);

		Person p2=new Person();
		p2.setpId(2);
		p2.setpName("Shreya");
		p2.setpContact(876543265);

		Vehical v1=new Vehical();
		v1.setvId(101);
		v1.setvName("cycle");
		v1.setvPrice(1650);
		
		Vehical v2=new Vehical();
		v2.setvId(102);
		v2.setvName(" Big cycle");
		v2.setvPrice(5650);
		
		// note :
		// to add the the different Object into collection that is present in person class
		// and it has declared as variable for the person
		
		p1.getVlist().add(v1);
		p1.getVlist().add(v2);
		


		Configuration cfg=new Configuration().configure().addAnnotatedClass(Person.class).addAnnotatedClass(Vehical.class);
		SessionFactory	sf=cfg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction trans=ses.beginTransaction();
		
		
		List<Object> lists=new ArrayList<Object>();
		lists.add(p1);
		lists.add(p2);
		lists.add(v1);
		lists.add(v2);
		
		for( Object list:lists)
		{
			ses.save(list);
			System.out.println(list);
		}
		
		trans.commit();
		ses.close();
	}
}
