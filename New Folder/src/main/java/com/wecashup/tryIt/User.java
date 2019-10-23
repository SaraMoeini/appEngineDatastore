package com.wecashup.tryIt;


import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;


@Entity
@Index
public class User {
    @Id Long id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;

    User() {}

     public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
         public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
      public String getPassword() {
        return password;
    }
    public void setPassword(String i) {
        this.password = i;
    }
         public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}