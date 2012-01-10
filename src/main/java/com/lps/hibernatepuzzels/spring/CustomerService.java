package com.lps.hibernatepuzzels.spring;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class CustomerService {

   @Resource
   private CustomerDao customerDao;

}
