package com.saas.accessmodifiers.p1;


public class GetDetails {
    public static void main(String[] args) {
        Person gd = new Person();
        gd.car="creta";
        gd.setName("Teja");
        gd.setAge(23);
        System.out.println(gd.getName());
        System.out.println(gd.getAge());
        System.out.println(gd.car);
    }
}
