package teagaspackage;

import component.weightmeasurement.LoadSensor;
import component.weightmeasurement.WeightMeasurement;
import microcontroller.ATMega32;
import microcontroller.Microncontroller;

public class Silver implements TeaGASPackage{

    public String createName() {
        return "Silver";
    }

    public Microncontroller createMicrocontroller() {
        return new ATMega32();
    }

    public WeightMeasurement createWeightMeasurement() {
        return new LoadSensor();
    }
}
