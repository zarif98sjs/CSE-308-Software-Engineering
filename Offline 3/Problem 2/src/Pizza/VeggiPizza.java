package Pizza;

public class VeggiPizza extends Pizza{

    public VeggiPizza()
    {
        description = "VeggiPizza";
    }

    @Override
    public double getCost() {
        return 500;
    }
}
