package com.lps.hibernatepuzzles;

import com.lps.hibernatepuzzles.model.Customer;
import com.lps.hibernatepuzzles.model.CustomerAddress;
import com.lps.hibernatepuzzles.model.CustomerEmailAddress;
import com.lps.hibernatepuzzles.support.HibernateSupport;
import com.lps.hibernatepuzzles.support.Logging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class CascadeIssue {

   public static void main(String[] args) {
      Logging.configure();

      SessionFactory sessionFactory = HibernateSupport.buildSessionFactory();

      Session session = sessionFactory.openSession();

      Logger logger = LoggerFactory.getLogger(CascadeIssue.class);

      logger.info("**** Start of test - Create a customer");
      Customer customer = new Customer();
      customer.setName("My Customer");

      logger.info("**** add new Address");
      customer.addAddress(new CustomerAddress());

      logger.info("**** save the customer object");
      session.save(customer);

      logger.info("**** adding a new email address");
      CustomerEmailAddress emailAddress = new CustomerEmailAddress("thing@example.com");
      customer.addEmailAddress(emailAddress);
      // have to save the object because there is
      session.save(emailAddress);

      logger.info("**** flush and close");
      session.flush();
      session.close();

      sessionFactory.close();
   }
}
