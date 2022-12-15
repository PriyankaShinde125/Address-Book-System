package org.example;

public class Address {
    private String area;
    private String city;
    private String state;
    private int zip;

    public Address(String area, String city, String state, int zip) {
        this.area = area;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return area + " , " + city + " , " + state + " , " + zip + "\n";
    }
}
