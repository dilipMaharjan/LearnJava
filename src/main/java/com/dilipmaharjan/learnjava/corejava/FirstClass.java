package com.dilipmaharjan.learnjava.corejava;

public class FirstClass {
    public static void main(String[] args) {
        //variable - liable to chage
        //keywords are predefined
        //data type stores the type
        String name = "Ashok";
        int number = 2;
        float floatingNumber = 2.3f;
        double doubleNumber = 4.5d;
        boolean trueFalse = true;
        char character = 'c';
        System.out.println(name);
        System.out.println(number);
        System.out.println(floatingNumber);
        System.out.println(doubleNumber);
        System.out.println(trueFalse);
        System.out.println(character);

        int acoountNumber = 123;
        String accountHoldersName = "Ashok";
        double balance = 123.34;

        String lightColor = "green";
        //conditional statement
        //traffic light , green , yellow, red
        if (lightColor.equals("green")) {
            System.out.println("Go");
        } else if (lightColor.equals("yellow")) {
            System.out.println("Prepare to stop");
        } else {
            System.out.println("Stop");
        }

        lightColor = "yellow";
        switch (lightColor) {
            case "green":
                System.out.println("Green");
                break;
            case "yellow":
                System.out.println("yellow");
                break;
            case "red":
                System.out.println("Stop");
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
