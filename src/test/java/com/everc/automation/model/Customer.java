package com.everc.automation.model;

public class Customer {

    private String email;
    private String password;
    private String userName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Customer() {
    }

    private Customer(final Builder builder) {
        email = builder.email;
        password = builder.password;
        userName = builder.userName;
    }

    public static final class Builder {
        private String email;
        private String password;
        private String userName;

        private Builder() {
        }

        public Builder withName(final String val) {
            email = val;
            return this;
        }

        public Builder withPassword(final String val) {
            password = val;
            return this;
        }

        public Builder withUserName(final String val) {
            userName = val;
            return this;
        }


        public Customer build() {
            return new Customer(this);
        }
    }

}