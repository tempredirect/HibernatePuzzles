package com.lps.hibernatepuzzles.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 */
@Entity
public class CustomerAddress {

   @Id
   @GeneratedValue
   private Long id;

   private String line1;
   private String line2;
   private String city;
   private String postcode;

   public CustomerAddress() {
   }

   public CustomerAddress(String line1, String postcode) {
      this.line1 = line1;
      this.postcode = postcode;
   }

   public String getLine1() {
      return line1;
   }

   public void setLine1(String line1) {
      this.line1 = line1;
   }

   public String getLine2() {
      return line2;
   }

   public void setLine2(String line2) {
      this.line2 = line2;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getPostcode() {
      return postcode;
   }

   public void setPostcode(String postcode) {
      this.postcode = postcode;
   }

   @Override
   public String toString() {
      return "Address{" +
            "id=" + id +
            ", line1='" + line1 + '\'' +
            ", line2='" + line2 + '\'' +
            ", city='" + city + '\'' +
            ", postcode='" + postcode + '\'' +
            '}';
   }
}
