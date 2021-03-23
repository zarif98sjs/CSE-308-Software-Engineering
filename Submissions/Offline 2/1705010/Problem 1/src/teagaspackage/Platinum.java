package teagaspackage;

import microcontroller.Microncontroller;
import microcontroller.RaspberryPi;

public class Platinum implements TeaGASPackage{

    String name;
    Microncontroller microncontroller;

    public String createName() {
        return "Platinum";
    }

    public Microncontroller createMicrocontroller() {
        return new RaspberryPi();
    }

    public String getMicrocontrollerType() {
        return "RaspberryPi";
    }

    public void create()
    {
        name = createName();
        microncontroller = createMicrocontroller();
        microncontroller.create();
        microncontroller.setWeightMeasurement("WeightModule");
    }

    @Override
    public String toString() {
        return "Platinum{" +
                "name='" + name + '\'' +
                ", microncontroller=" + microncontroller +
                '}';
    }
}
