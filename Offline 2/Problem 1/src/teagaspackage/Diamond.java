package teagaspackage;

import microcontroller.ArduinoMega;
import microcontroller.Microncontroller;
import microcontroller.RaspberryPi;

public class Diamond implements TeaGASPackage{

    String name;
    Microncontroller microncontroller;

    public String createName() {
        return "Diamond";
    }

    public Microncontroller createMicrocontroller() {
        return new RaspberryPi();
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
        return "Diamond{" +
                "name='" + name + '\'' +
                ", microncontroller=" + microncontroller +
                '}';
    }
}
