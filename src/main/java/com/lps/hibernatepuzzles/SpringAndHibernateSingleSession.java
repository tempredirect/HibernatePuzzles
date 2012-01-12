package com.lps.hibernatepuzzles;

import com.lps.hibernatepuzzles.model.Customer;
import com.lps.hibernatepuzzles.spring.CustomerDao;
import com.lps.hibernatepuzzles.spring.CustomerService;
import com.lps.hibernatepuzzles.support.DataGenerator;
import com.lps.hibernatepuzzles.support.Logging;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static com.lps.hibernatepuzzles.support.HibernateSupport.sessionTotal;

/**
 *
 */
public class SpringAndHibernateSingleSession {

   public static void main(String[] args) {
      Logging.configure();
      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/lps/hibernatepuzzles/spring-and-hibernate.xml");
      context.getBean(DataGenerator.class).createCustomerRecords(1, 3);
      Logger logger = LoggerFactory.getLogger(SpringAndHibernateSingleSession.class);
      SessionFactory sessionFactory = context.getBean(SessionFactory.class);
      CustomerDao customerDao = context.getBean(CustomerDao.class);
      CustomerService customerService = context.getBean(CustomerService.class);
      sessionFactory.getStatistics().clear();

      // *********************************************************************

      Customer customer = customerDao.get(1L);

      customer.setName("Wibble");

      customerDao.saveOrUpdate(customer);

      logger.info("Number of opened sessions {}", sessionTotal(sessionFactory));

      sessionFactory.getStatistics().clear();

      customerService.changeName(1L, "Wobbler");
      logger.info("Number of opened sessions {}", sessionTotal(sessionFactory));

   }
}
