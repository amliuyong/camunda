package org.camunda.demo.model;

public class CustomerData {

    protected String firstname;
    protected String lastname;
    protected boolean isVip;
    protected float rating;
    protected Address[] addresses = new Address[]{};

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

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean isVip) {
        this.isVip = isVip;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }

    public String toString() {
        return "CustomerData [firstname=" + firstname + ", lastname=" + lastname + ", isVip=" + isVip + ", rating=" + rating + ", addresses=" + addresses + "]";
    }

}