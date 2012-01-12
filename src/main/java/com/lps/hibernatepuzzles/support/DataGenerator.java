package com.lps.hibernatepuzzles.support;

import com.lps.hibernatepuzzles.model.Customer;
import com.lps.hibernatepuzzles.model.CustomerAddress;
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
      Logging.disableSql();
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
      Logging.enableSql();
   }
}
