package org.example;

import java.util.Scanner;

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

    public Address() {
        Scanner sc=new Scanner(System.in);
        System.out.print("\n Area = ");
        area = sc.next();
        System.out.print("\n City = ");
        city = sc.next();
        System.out.print("\n State = ");
        state = sc.next();
        System.out.print("\n Zip = ");
        zip = sc.nextInt();
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
