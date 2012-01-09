package com.lps.hibernatepuzzels.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class EmailAddress {

   @Id
   @GeneratedValue
   private Long id;

   private String emailAddress;

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
