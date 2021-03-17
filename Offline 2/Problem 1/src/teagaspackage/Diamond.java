package teagaspackage;

import component.weightmeasurement.LoadSensor;
import component.weightmeasurement.WeightMeasurement;
import microcontroller.Microncontroller;
import microcontroller.RaspberryPi;

public class Diamond implements TeaGASPackage{

    public String createName() {
        return "Diamond";
    }

    public Microncontroller createMicrocontroller() {
        return new RaspberryPi();
    }

    public WeightMeasurement createWeightMeasurement() {
        return new LoadSensor();
    }
}
