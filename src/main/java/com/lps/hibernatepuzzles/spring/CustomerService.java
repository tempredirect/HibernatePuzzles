package com.lps.hibernatepuzzles.spring;

import com.lps.hibernatepuzzles.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 */
@Service
@Transactional
public class CustomerService {

   @Resource
   private CustomerDao customerDao;


   public void changeName(long id, String name) {
      Customer customer = customerDao.get(id);

      customer.setName(name);

      customerDao.saveOrUpdate(customer);
   }

}
