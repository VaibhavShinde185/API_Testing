package com.thetestingacademy;

public class noDesignPattern {

    public void floor1(){
        System.out.println("Step 1");
    }
//    public void floor2(int 6){      // passing a argument
//        System.out.println("Step 2");
//    }
    public  void floor3(String Param){
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        noDesignPattern NDP = new noDesignPattern();
        NDP.floor1();
        //NDP.floor2();
        NDP.floor3("Vaibhav");
    }

}
//Need to check example of function with argument