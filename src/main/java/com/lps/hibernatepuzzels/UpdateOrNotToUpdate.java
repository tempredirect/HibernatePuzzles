package com.lps.hibernatepuzzels;

import com.lps.hibernatepuzzels.model.Customer;
import com.lps.hibernatepuzzels.model.Status;
import com.lps.hibernatepuzzels.support.DataGenerator;
import com.lps.hibernatepuzzels.support.HibernateSupport;
import com.lps.hibernatepuzzels.support.Logging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class UpdateOrNotToUpdate {

   public static void main(String[] args) {
      Logging.configure();

      SessionFactory sessionFactory = HibernateSupport.buildSessionFactory();
      DataGenerator generator = new DataGenerator(sessionFactory);
      generator.createCustomerRecords(1);

      Logger logger = LoggerFactory.getLogger(UpdateOrNotToUpdate.class);

      logger.info("***** starting");

      Session session = sessionFactory.openSession();
      Customer customer = (Customer) session.get(Customer.class, 1L);

      logger.info("***** setting name");
      customer.setName("My Customer");

      logger.info("***** save or update 1");
      session.saveOrUpdate(customer);

      customer.setStatus(Status.DISABLED);

      logger.info("***** save or update 2");
      session.saveOrUpdate(customer);

      logger.info("***** flush session");
      session.flush();
      session.close();

      logger.info("***** finished");
      sessionFactory.close();
   }
}
