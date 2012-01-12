package com.lps.hibernatepuzzles.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class CustomerEmailAddress {

   @Id
   @GeneratedValue
   private Long id;

   private String emailAddress;

   public CustomerEmailAddress() {
   }

   public CustomerEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
   }

   public String getEmailAddress() {
      return emailAddress;
   }

   public void setEmailAddress(String emailAddress) {
      this.emailAddress = emailAddress;
   }

   @Override
   public String toString() {
      return "EmailAddress{" +
            "id=" + id +
            ", emailAddress='" + emailAddress + '\'' +
            '}';
   }
}
