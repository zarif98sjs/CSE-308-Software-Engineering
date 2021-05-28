package Appetizer;

import Pizza.Pizza;

public class FrenchFry extends AppetizerDecorator{

    Pizza pizza;

    public FrenchFry(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", French Fry";
    }

    @Override
    public double getCost() {
        return 100 + pizza.getCost();
    }
}
