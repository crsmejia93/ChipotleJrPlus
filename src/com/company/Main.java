package com.company;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*
    * This program will assemble 25 burritos by using a random number and selecting from the
    * an array of ingredients: Rice, Meat, Beans, Salsa, Veggies, Cheese, Guac, Sour Cream.
    * */

    public static void main(String[] args) {
        final int QUANTITY =25;//The number of burritos that will be made
        Scanner input = new Scanner(System.in);
        //INGREDIENTS
        String[] rice = {"White Rice", "Brown Rice", "No Rice"};
        String[] meat = {"Chicken", "Steak", "Carnitas", "Chorizo", "Sofritas","Veggies"};
        String[] beans = {"Pinto Beans", "Black Beans","No Beans"};
        String[] salsa = {"Mild Salsa", "Medium Salsa", "Hot Salsa", "All Salsas", "No Meat"};
        String[] veggies = {"Lettuce", "Fajita veggies", "No Veggies", "All Veggies"};
        //The burrito that will hold the ingredients
        HashMap<String, String> burritos = new HashMap<>();
        for(int i = 0; i<=QUANTITY; i++){
            //This random will be used to produce a random true or false
            Random random = new Random();
            //The lines 27 to 31 will add all the ingredients into the string ingredients.
            String tempStr ="", ingredients;
            ingredients = tempStr.concat(addRice(rice));
            ingredients += tempStr.concat(", "+addMeat(meat));
            ingredients += tempStr.concat(", "+addBeans(beans));
            ingredients += tempStr.concat(", "+addSalsa(salsa));
            ingredients += tempStr.concat(", "+addVeggies(veggies));
            //The ingredients will be stored into the HashMap burritos
            if(getRandomBoolean(random)){
                ingredients +=tempStr.concat(", Cheese");
            }
            if(getRandomBoolean(random)){
                ingredients +=tempStr.concat(", Guacamole");
            }
            if(getRandomBoolean(random)){
                ingredients +=tempStr.concat(", Sour Cream");
            }
            burritos.put("Burrito"+i,ingredients);
        }
        for(int i=0; i<burritos.size()-1;i++){
            System.out.printf("Burrito %d: %s\n",i+1,burritos.get("Burrito"+i));
        }
    }
    //METHODS----------------------------------------------------------------------------------
    private static boolean getRandomBoolean(Random random){
        //This is a simplified if statement
        //I found the formula on StackOverFlow
        return (random.nextInt(2)==0) ? true: false;
    }

    private static String addVeggies(String[] veggies) {
        int index = (int)(Math.random()*veggies.length);
        return veggies[index];
    }

    private static String addSalsa(String[] salsa) {
        int index = (int)(Math.random()*salsa.length);
        return salsa[index];
    }

    private static String addBeans(String[] beans) {
        int index = (int)(Math.random()*beans.length);
        return beans[index];
    }

    private static String addMeat(String[] meat) {
        int index = (int)(Math.random()*meat.length);
        return meat[index];
    }

    private static String addRice(String[] rice) {
        int index = (int)(Math.random()*rice.length);
        return rice[index];
    }
}