package Drinks;

import Pizza.Pizza;

public class Coffee extends DrinksDecorator{

    Pizza pizza;

    public Coffee(Pizza pizza)
    {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", Coffee";
    }

    @Override
    public double getCost() {
        return 50 + pizza.getCost();
    }
}