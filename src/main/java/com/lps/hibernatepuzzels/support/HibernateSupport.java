package com.lps.hibernatepuzzels.support;

import com.lps.hibernatepuzzels.model.Customer;
import com.lps.hibernatepuzzels.model.CustomerAddress;
import com.lps.hibernatepuzzels.model.CustomerEmailAddress;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.HSQLDialect;

import java.util.Collections;
import java.util.Map;

/**
 *
 */
public class HibernateSupport {

   public static SessionFactory buildSessionFactory() {
      return buildSessionFactory(Collections.<String, String>emptyMap());
   }

   public static SessionFactory buildSessionFactory(Map<String, String> properties) {
      AnnotationConfiguration cfg = new AnnotationConfiguration()
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(CustomerAddress.class)
            .addAnnotatedClass(CustomerEmailAddress.class)
            .setProperty(Environment.DIALECT, HSQLDialect.class.getName())
            .setProperty(Environment.DRIVER, org.hsqldb.jdbcDriver.class.getName())
            .setProperty(Environment.URL, "jdbc:hsqldb:mem:mymemdb")
            .setProperty(Environment.HBM2DDL_AUTO, "create")
            .setProperty(Environment.USE_SQL_COMMENTS, "true");

      for (Map.Entry<String, String> entry : properties.entrySet()) {
         cfg.setProperty(entry.getKey(), entry.getValue());
      }
      return cfg.buildSessionFactory();
   }
}
