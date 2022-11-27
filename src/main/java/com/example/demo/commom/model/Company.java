package com.example.demo.commom.model;

public class Company implements Cloneable{

    private User user;

    private String address;

    public Company(User user, String address) {
        super();
        this.user = user;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        Company company = (Company) obj;
        if (user.equals(company.getUser()) && address.equals(company.address)) {
            return true;
        }
        return false;
    }

}
