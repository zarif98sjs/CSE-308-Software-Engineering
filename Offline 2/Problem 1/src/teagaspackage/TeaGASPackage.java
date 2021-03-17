package teagaspackage;

import component.weightmeasurement.WeightMeasurement;
import microcontroller.Microncontroller;

public interface TeaGASPackage {

    public String createName();
    public Microncontroller createMicrocontroller();
    public WeightMeasurement createWeightMeasurement();

}
