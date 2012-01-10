package com.lps.hibernatepuzzels.support;

import com.lps.hibernatepuzzels.model.Customer;
import com.lps.hibernatepuzzels.model.CustomerAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 */
public class DataGenerator {

   private SessionFactory sessionFactory;

   public DataGenerator(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   public void createCustomerRecords(int customerCount, int addressCount) {
      Session session = sessionFactory.openSession();
      for (int i = 1; i <= customerCount; i++) {
         Customer c = new Customer();

         c.setName("Customer " + i);

         for (int j = 1; j <= addressCount; j++) {
            c.addAddress(new CustomerAddress("Street " + addressCount, "EX15 " + j + "BW"));
         }
         session.save(c);
      }

      session.close();
   }
}
