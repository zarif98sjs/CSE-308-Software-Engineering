package teagaspackage;

import component.weightmeasurement.WeightMeasurement;
import component.weightmeasurement.WeightModule;
import microcontroller.ArduinoMega;
import microcontroller.Microncontroller;

public class Gold implements TeaGASPackage{

    public String createName() {
        return "Gold";
    }

    public Microncontroller createMicrocontroller() {
        return new ArduinoMega();
    }

    public WeightMeasurement createWeightMeasurement() {
        return new WeightModule();
    }
}
