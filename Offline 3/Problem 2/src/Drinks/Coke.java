package Drinks;

import Pizza.Pizza;

public class Coke extends DrinksDecorator{

    Pizza pizza;

    public Coke(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", Coke";
    }

    @Override
    public double getCost() {
        return 20 + pizza.getCost();
    }
}