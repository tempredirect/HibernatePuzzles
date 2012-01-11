package com.lps.hibernatepuzzels;

import com.lps.hibernatepuzzels.spring.CustomerDao;
import com.lps.hibernatepuzzels.support.DataGenerator;
import com.lps.hibernatepuzzels.support.Logging;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

import static com.lps.hibernatepuzzels.support.HibernateSupport.openSessionCount;

/**
 *
 */
public class SpringAndHibernate {

   public static void main(String[] args) throws SQLException {
      Logging.configure();
      Logger logger = LoggerFactory.getLogger(SpringAndHibernate.class);

      ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/com/lps/hibernatepuzzels/spring-and-hibernate.xml");

      context.getBean(DataGenerator.class).createCustomerRecords(1, 3);

      SessionFactory sessionFactory = context.getBean(SessionFactory.class);

      // *********************************************************************

      CustomerDao customerDao = context.getBean(CustomerDao.class);

      logger.info("get " + openSessionCount(sessionFactory));
      customerDao.get(1L);
      logger.info("get " + openSessionCount(sessionFactory));

      customerDao.badGet(1L);
      logger.info("badGet " + openSessionCount(sessionFactory));

      ComboPooledDataSource dataSource = context.getBean(ComboPooledDataSource.class);

      logger.info("connections in use :" + dataSource.getNumBusyConnections());
   }

}
