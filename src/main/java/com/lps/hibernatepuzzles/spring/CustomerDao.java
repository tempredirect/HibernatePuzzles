package com.lps.hibernatepuzzles.spring;

import com.lps.hibernatepuzzles.model.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao extends HibernateDaoSupport {

   @Autowired
   public CustomerDao(SessionFactory sessionFactory) {
      setSessionFactory(sessionFactory);
   }

   public Customer get(long id) {
      return getHibernateTemplate().get(Customer.class, id);
   }

   public Customer badGet(long id) {
      return (Customer) getSession().get(Customer.class, id);
   }

   public void saveOrUpdate(Customer customer) {
      getHibernateTemplate().saveOrUpdate(customer);
   }
}
