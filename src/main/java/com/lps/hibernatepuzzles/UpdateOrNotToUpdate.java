package com.lps.hibernatepuzzles;

import com.lps.hibernatepuzzles.model.Customer;
import com.lps.hibernatepuzzles.model.Status;
import com.lps.hibernatepuzzles.support.DataGenerator;
import com.lps.hibernatepuzzles.support.HibernateSupport;
import com.lps.hibernatepuzzles.support.Logging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Can you predict how many and at what point the Customer table is updated?
 */
public class UpdateOrNotToUpdate {

   public static void main(String[] args) {
      Logging.configure();

      SessionFactory sessionFactory = HibernateSupport.buildSessionFactory();
      DataGenerator generator = new DataGenerator(sessionFactory);
      generator.createCustomerRecords(1, 0);

      Logger logger = LoggerFactory.getLogger(UpdateOrNotToUpdate.class);

      logger.info("***** starting");

      Session session = sessionFactory.openSession();

      Customer customer = (Customer) session.get(Customer.class, 1L);

      logger.info("***** setting name");
      // Option A
      customer.setName("My Customer");

      logger.info("***** save or update 1");
      // Option B
      session.saveOrUpdate(customer);

      customer.setStatus(Status.DISABLED);

      logger.info("***** save or update 2");
      // Option C
      session.saveOrUpdate(customer);

      logger.info("***** flush and close session");

      // Option D - None of the above
      session.flush();
      session.close();

      logger.info("***** finished");
      sessionFactory.close();
   }
}
