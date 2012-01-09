package com.lps.hibernatepuzzels;

import com.lps.hibernatepuzzels.model.Address;
import com.lps.hibernatepuzzels.model.Customer;
import com.lps.hibernatepuzzels.support.DataGenerator;
import com.lps.hibernatepuzzels.support.HibernateSupport;
import com.lps.hibernatepuzzels.support.Logging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 */
public class CascadeIssue {

   public static void main(String[] args) {
      Logging.configure();

      SessionFactory sessionFactory = HibernateSupport.buildSessionFactory();

      new DataGenerator(sessionFactory).createCustomerRecords(1);

      Session session = sessionFactory.openSession();

      Customer customer = (Customer) session.get(Customer.class, 1L);

      customer.addAddress(new Address());
      //      customer.addEmailAddress(new EmailAddress());
      //      customer.setName("Thing");

      session.flush();
      session.close();

      sessionFactory.close();
   }
}
