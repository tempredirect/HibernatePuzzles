package com.lps.hibernatepuzzles;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.lps.hibernatepuzzles.model.Customer;
import com.lps.hibernatepuzzles.model.CustomerAddress;
import com.lps.hibernatepuzzles.support.DataGenerator;
import com.lps.hibernatepuzzles.support.HibernateSupport;
import com.lps.hibernatepuzzles.support.Logging;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.apache.commons.lang.StringUtils.rightPad;

/**
 *
 */
public class OnePlusMany {

   public static void main(String[] args) {
      Logging.configure();

      SessionFactory sessionFactory = HibernateSupport.buildSessionFactory();
      new DataGenerator(sessionFactory).createCustomerRecords(50, 3);

      Logger logger = LoggerFactory.getLogger(UpdateOrNotToUpdate.class);

      logger.info("**** starting - default batch_size");

      runReport(sessionFactory, logger);

      sessionFactory.close();

      sessionFactory = HibernateSupport.buildSessionFactory(ImmutableMap.of(
            Environment.HBM2DDL_AUTO, "", // reset the auto config
            Environment.DEFAULT_BATCH_FETCH_SIZE, "16")
      );
      new DataGenerator(sessionFactory).createCustomerRecords(50, 3);

      logger.info("**** starting - batch_size 16");
      runReport(sessionFactory, logger);

   }

   @SuppressWarnings("unchecked")
   private static void runReport(SessionFactory sessionFactory, Logger logger) {
      Session session = sessionFactory.openSession();

      List<Customer> results = session.createQuery("from Customer").list();

      logger.info("**** Build report");

      StringBuilder out = new StringBuilder();
      for (Customer customer : results) {
         out.append("\n|").append(rightPad(customer.getName(), 20)).append("|");
         out.append(rightPad(Joiner.on(",").join(Iterables.transform(customer.getAddresses(), new Function<CustomerAddress, String>() {
            @Override
            public String apply(CustomerAddress customerAddress) {
               return customerAddress.getLine1() + "," + customerAddress.getPostcode();
            }
         })), 50)).append("|");
      }
      System.out.println(out.toString());
      session.close();
   }
}
