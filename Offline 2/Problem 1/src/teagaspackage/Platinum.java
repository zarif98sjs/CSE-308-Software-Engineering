package teagaspackage;

import component.weightmeasurement.WeightMeasurement;
import component.weightmeasurement.WeightModule;
import microcontroller.Microncontroller;
import microcontroller.RaspberryPi;

public class Platinum implements TeaGASPackage{

    public String createName() {
        return "Platinum";
    }

    public Microncontroller createMicrocontroller() {
        return new RaspberryPi();
    }

    public WeightMeasurement createWeightMeasurement() {
        return new WeightModule();
    }
}
