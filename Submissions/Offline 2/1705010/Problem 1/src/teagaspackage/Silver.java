package teagaspackage;

import microcontroller.ATMega32;
import microcontroller.Microncontroller;

public class Silver implements TeaGASPackage{

    String name;
    Microncontroller microncontroller;

    public String createName() {
        return "Silver";
    }

    public Microncontroller createMicrocontroller() {
        return new ATMega32();
    }

    @Override
    public String getMicrocontrollerType() {
        return "ATMega32";
    }

    public void create()
    {
        name = createName();
        microncontroller = createMicrocontroller();
        microncontroller.create();
        microncontroller.setWeightMeasurement("LoadSensor");
    }

    @Override
    public String toString() {
        return "Silver{" +
                "name='" + name + '\'' +
                ", microncontroller=" + microncontroller +
                '}';
    }
}
