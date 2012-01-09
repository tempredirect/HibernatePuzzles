package com.lps.hibernatepuzzels.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

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

   @OneToMany(cascade = CascadeType.ALL)
   @JoinColumn(name = "customer")
   private Set<Address> addresses = new LinkedHashSet<>();

   @OneToMany( /* default cascade is no cascade */)
   @JoinColumn(name = "customer")
   private Set<EmailAddress> emailAddresses = new LinkedHashSet<>();

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

   public Set<Address> getAddresses() {
      return new LinkedHashSet<>(addresses);
   }

   public void addAddress(Address address) {
      addresses.add(address);
   }

   public Set<EmailAddress> getEmailAddresses() {
      return new LinkedHashSet<>(emailAddresses);
   }

   public void addEmailAddress(EmailAddress emailAddress) {
      emailAddresses.add(emailAddress);
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
