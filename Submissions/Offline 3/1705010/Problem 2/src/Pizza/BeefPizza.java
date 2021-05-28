package Pizza;

public class BeefPizza extends Pizza{

    public BeefPizza()
    {
        description = "BeefPizza";
    }

    @Override
    public double getCost() {
        return 800;
    }
}
