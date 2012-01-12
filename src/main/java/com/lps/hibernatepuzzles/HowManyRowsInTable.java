package com.lps.hibernatepuzzles;

import com.lps.hibernatepuzzles.model.Customer;
import com.lps.hibernatepuzzles.support.DataGenerator;
import com.lps.hibernatepuzzles.support.HibernateSupport;
import com.lps.hibernatepuzzles.support.Logging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * So there are 50 rows in the table, how many items will be results of the query 'from Customer c left join fetch c.addresses'
 */
public class HowManyRowsInTable {

   @SuppressWarnings("unchecked")
   public static void main(String[] args) {
      Logging.configure();

      SessionFactory sessionFactory = HibernateSupport.buildSessionFactory();
      new DataGenerator(sessionFactory).createCustomerRecords(50, 3);

      Logger logger = LoggerFactory.getLogger(UpdateOrNotToUpdate.class);

      Session session = sessionFactory.openSession();

      List<Customer> results = session.createQuery("from Customer c left join fetch c.addresses").list();

      logger.info("How may Customers where you expecting? : {}", results.size());
   }
}
