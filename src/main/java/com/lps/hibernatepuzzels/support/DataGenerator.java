package com.lps.hibernatepuzzels.support;

import com.lps.hibernatepuzzels.model.Customer;
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

   public void createCustomerRecords(int count){
      Session session = sessionFactory.openSession();
      for( int i = 0; i < count ; i ++){
         Customer c = new Customer();
         
         c.setName("Customer " + i);
         
         session.save(c);
      }
      
      session.close();
   }
}
