package Appetizer;

import Pizza.Pizza;

public class OnionRing extends AppetizerDecorator{

    Pizza pizza;

    public OnionRing(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", Onion Ring";
    }

    @Override
    public double getCost() {
        return 100 + pizza.getCost();
    }
}
