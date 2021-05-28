package com.company;

import Appetizer.FrenchFry;
import Appetizer.OnionRing;

import Drinks.Coke;
import Drinks.Coffee;

import Pizza.BeefPizza;
import Pizza.Pizza;
import Pizza.VeggiPizza;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Pizza pizza1 = new BeefPizza();
        pizza1 = new FrenchFry(pizza1);
        System.out.println("Desciption : "+pizza1.getDescription() + " . Cost : "+pizza1.getCost());

        Pizza pizza2 = new VeggiPizza();
        pizza2 = new OnionRing(pizza2);
        System.out.println("Desciption : "+pizza2.getDescription() + " . Cost : "+pizza2.getCost());

        Pizza pizza3 = new VeggiPizza();
        pizza3 = new FrenchFry(pizza3);
        pizza3 = new Coke(pizza3);
        System.out.println("Desciption : "+pizza3.getDescription() + " . Cost : "+pizza3.getCost());

        Pizza pizza4 = new VeggiPizza();
        pizza4 = new OnionRing(pizza4);
        pizza4 = new Coffee(pizza4);
        System.out.println("Desciption : "+pizza4.getDescription() + " . Cost : "+pizza4.getCost());

        Pizza pizza5 = new BeefPizza();
        System.out.println("Desciption : "+pizza5.getDescription() + " . Cost : "+pizza5.getCost());

    }
}
