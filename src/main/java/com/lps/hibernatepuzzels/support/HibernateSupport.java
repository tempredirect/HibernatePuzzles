package com.lps.hibernatepuzzels.support;

import com.lps.hibernatepuzzels.model.Address;
import com.lps.hibernatepuzzels.model.Customer;
import com.lps.hibernatepuzzels.model.EmailAddress;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.HSQLDialect;

/**
 *
 */
public class HibernateSupport {

   public static SessionFactory buildSessionFactory() {
      AnnotationConfiguration cfg = new AnnotationConfiguration()
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Address.class)
            .addAnnotatedClass(EmailAddress.class)
            .setProperty(Environment.DIALECT, HSQLDialect.class.getName())
            .setProperty(Environment.DRIVER, org.hsqldb.jdbcDriver.class.getName())
            .setProperty(Environment.URL, "jdbc:hsqldb:mem:mymemdb")
            .setProperty(Environment.HBM2DDL_AUTO, "create");

      return cfg.buildSessionFactory();
   }
}
