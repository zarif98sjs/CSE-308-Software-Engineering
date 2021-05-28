package teagaspackage;

import microcontroller.ATMega32;
import microcontroller.ArduinoMega;
import microcontroller.Microncontroller;

public class Gold implements TeaGASPackage{

    String name;
    Microncontroller microncontroller;

    public String createName() {
        return "Gold";
    }

    public Microncontroller createMicrocontroller() {
        return new ArduinoMega();
    }

    public String getMicrocontrollerType() {
        return "ArduinoMega";
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
        return "Gold{" +
                "name='" + name + '\'' +
                ", microncontroller=" + microncontroller +
                '}';
    }
}
