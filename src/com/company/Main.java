package com.company;

import java.util.HashMap;
import java.util.Random;

public class Main {
    /*
    * This program will assemble 25 burritos by using a random number and selecting from
    * an array of ingredients: Rice, Meat, Beans, Salsa, Veggies, Cheese, Guac, Sour Cream.
    * It will then calculate the pricing and out put it under the burrito line with all its ingredients.
    * */

    public static void main(String[] args) {
        final int QUANTITY = 25;//The number of burritos that will be made
        //INGREDIENTS
        String[] rice = {"White Rice", "Brown Rice", "No Rice"};
        String[] meat = {"Chicken", "Steak", "Carnitas", "Chorizo", "Sofritas", "Veggies"};
        String[] beans = {"Pinto Beans", "Black Beans", "No Beans"};
        String[] salsa = {"Mild Salsa", "Medium Salsa", "Hot Salsa", "All Salsas", "No Meat"};
        String[] veggies = {"Lettuce", "Fajita veggies", "No Veggies", "All Veggies"};
        //The burrito that will hold the ingredients
        HashMap<String, String> burritos = new HashMap<>();
        for (int i = 0; i < QUANTITY; i++) {
            //This random will be used to produce a random true or false
            Random random = new Random();
            //The lines 27 to 31 will add(concatenate) all the ingredients into the string ingredients.
            String tempStr = "", ingredients;
            ingredients = tempStr.concat(addRice(rice));
            ingredients += tempStr.concat(", " + addMeat(meat));
            ingredients += tempStr.concat(", " + addBeans(beans));
            ingredients += tempStr.concat(", " + addSalsa(salsa));
            ingredients += tempStr.concat(", " + addVeggies(veggies));
            //This section will randomly add additional ingredient/toppings by
            //by gettting random true or false values
            if (getRandomBoolean(random)) {
                ingredients += tempStr.concat(", Cheese");
            }
            if (getRandomBoolean(random)) {
                ingredients += tempStr.concat(", Guacamole");
            }
            if (getRandomBoolean(random)) {
                ingredients += tempStr.concat(", Sour Cream");
            }
            //The ingredients will be stored into the HashMap burritos
            burritos.put("Burrito" + i, ingredients);
        }
        double total;
        for (int i = 0; i < burritos.size(); i++) {
            //This passes each String value according to the String key being passed to the get()
            total = getTotal(burritos.get("Burrito" + i));
            System.out.printf("Burrito %d: %s\n Total: $%.2f\n", i + 1, burritos.get("Burrito" + i),total);
        }
    }
    //METHODS----------------------------------------------------------------------------------//
    private static double getTotal(String ingredients) {
        double Total=3.00;//initial price for the burrito
        //This iterates through each ingredient and adds the cost accordingly
        for(String ingredient: ingredients.split(", ")){
            switch (ingredient){
                case "White Rice":
                    Total+=.50;
                    break;
                case "Brown Rice":
                    Total+=.50;
                    break;
                case "Chicken":
                    Total+=.50;
                    break;
                case "Steak":
                    Total+=.50;
                    break;
                case "Carnitas":
                    Total+=.50;
                    break;
                case "Chorizo":
                    Total+=.50;
                    break;
                case "Sofritas":
                    Total+=.50;
                    break;
                case "Veggies":
                    Total+=.50;
                    break;
                case "Pinto Beans":
                    Total+=.50;
                    break;
                case "Black Beans":
                    Total+=.50;
                    break;
                case "Mild Salsa":
                    Total+=.50;
                    break;
                case "Medium Salsa":
                    Total+=.50;
                    break;
                case "Hot Salsa":
                    Total+=.50;
                    break;
                case "All Salsas":
                    Total+=1.50;
                    break;
                case "Lettuce":
                    Total+=.50;
                    break;
                case "Fajita veggies":
                    Total+=.50;
                    break;
                case "All Veggies":
                    Total+=1.50;
                    break;
                case "Cheese":
                    Total+=.50;
                    break;
                case "Guacamole":
                    Total+=.50;
                    break;
                case "Sour Cream":
                    Total+=.50;
                    break;
                default:
                    Total+=0;
            }//end switch
        }//end for-loop
        return Total;
    }

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
