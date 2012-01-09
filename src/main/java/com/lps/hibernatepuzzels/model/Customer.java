package com.lps.hibernatepuzzels.model;

import javax.persistence.*;

/**
 *
 */
@Entity
public class Customer {
   
   @Id
   @GeneratedValue
   private Long id;
   
   private String name;
   
   private String telephoneNumber;
   
   @Enumerated(EnumType.STRING)
   private Status status = Status.ENABLED;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getTelephoneNumber() {
      return telephoneNumber;
   }

   public void setTelephoneNumber(String telephoneNumber) {
      this.telephoneNumber = telephoneNumber;
   }

   public Status getStatus() {
      return status;
   }

   public void setStatus(Status status) {
      this.status = status;
   }

   @Override
   public String toString() {
      return "Customer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", telephoneNumber='" + telephoneNumber + '\'' +
            ", status=" + status +
            '}';
   }
}
