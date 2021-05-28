package Pizza;

public abstract class Pizza {
    String description;

    public String getDescription(){
        return description;
    }

    public abstract double getCost();
}
