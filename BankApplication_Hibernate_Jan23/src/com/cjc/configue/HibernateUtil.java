package com.cjc.configue;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.cjc.model.Account;

public class HibernateUtil {

	private static SessionFactory sf = null;

	public static SessionFactory getSessionFactory() {
		Map<String, String> map = new HashMap<>();
		// connection properties Driverclass,url,username,password
		map.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		map.put(Environment.URL, "jdbc:mysql://localhost:3306/fd16");
		map.put(Environment.USER, "root");
		map.put(Environment.PASS, "kiran");

		// Hibernate properties Dialect ,hbm2ddl.auto, show_sql
		map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57Dialect");
		map.put(Environment.HBM2DDL_AUTO, "update");
		map.put(Environment.SHOW_SQL, "true");

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(map).build();

		MetadataSources mds = new MetadataSources(registry);

		mds.addAnnotatedClass(Account.class);

		Metadata md = mds.getMetadataBuilder().build();

		sf = md.getSessionFactoryBuilder().build();

		return sf;
	}

}
