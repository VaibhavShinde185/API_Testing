package com.thetestingacademy;

public class builderDesignPattern {
    //Change return type of each method as Class type
    //"this" always points to current/ calling object. Returning the same to have same reference

    public builderDesignPattern floor1(){
        System.out.println("Stage 1 is done");
        return this;
    }
    public builderDesignPattern floor2(String param){
        System.out.println("Stage 2 is done");
        return this;
    }
    public builderDesignPattern floor3(){
        System.out.println("Stage 3 is done");
        return  this;
    }

    public static void main(String[] args) {
         builderDesignPattern bdp = new builderDesignPattern();
         bdp.floor1().floor3().floor2("vaibhav");
    }

}
