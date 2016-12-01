package com.mobulum.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = User.UserBuilder.class)
public class User {
    private final Long id;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String phone;
    private final Integer userStatus;
    

    private User(Long id, String username, String firstName, String lastName, String email, String password, String phone, Integer userStatus) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userStatus = userStatus;
        
    }

    public Long getId() {
      return id;
    }
    public String getUsername() {
      return username;
    }
    public String getFirstName() {
      return firstName;
    }
    public String getLastName() {
      return lastName;
    }
    public String getEmail() {
      return email;
    }
    public String getPassword() {
      return password;
    }
    public String getPhone() {
      return phone;
    }
    public Integer getUserStatus() {
      return userStatus;
    }
    


    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, email, password, phone, userStatus);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.id, other.id) && 
                Objects.equals(this.username, other.username) && 
                Objects.equals(this.firstName, other.firstName) && 
                Objects.equals(this.lastName, other.lastName) && 
                Objects.equals(this.email, other.email) && 
                Objects.equals(this.password, other.password) && 
                Objects.equals(this.phone, other.phone) && 
                Objects.equals(this.userStatus, other.userStatus);
                
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + "', " +
                "username='" + username + "', " +
                "firstName='" + firstName + "', " +
                "lastName='" + lastName + "', " +
                "email='" + email + "', " +
                "password='" + password + "', " +
                "phone='" + phone + "', " +
                "userStatus='" + userStatus + "'" +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder
    public static final class UserBuilder {
        private Long id;
        private String username;
        private String firstName;
        private String lastName;
        private String email;
        private String password;
        private String phone;
        private Integer userStatus;
        

        private UserBuilder() {
        }

        public static UserBuilder aUser() {
            return new UserBuilder();
        }

        public UserBuilder withId(Long id) {
          this.id = id;
          return this;
        }
        public UserBuilder withUsername(String username) {
          this.username = username;
          return this;
        }
        public UserBuilder withFirstName(String firstName) {
          this.firstName = firstName;
          return this;
        }
        public UserBuilder withLastName(String lastName) {
          this.lastName = lastName;
          return this;
        }
        public UserBuilder withEmail(String email) {
          this.email = email;
          return this;
        }
        public UserBuilder withPassword(String password) {
          this.password = password;
          return this;
        }
        public UserBuilder withPhone(String phone) {
          this.phone = phone;
          return this;
        }
        public UserBuilder withUserStatus(Integer userStatus) {
          this.userStatus = userStatus;
          return this;
        }
        

        public User build() {
            return new User(id, username, firstName, lastName, email, password, phone, userStatus);
        }
    }
}
