package microcontroller;

import component.hardware.controller.Controller;
import component.hardware.display.Display;
import component.hardware.identification.Identfication;
import component.hardware.storage.Storage;
import component.hardware.weightmeasurement.LoadSensor;
import component.hardware.weightmeasurement.WeightMeasurement;
import component.hardware.weightmeasurement.WeightModule;

/*
* works as a component factory
* */
public abstract class Microncontroller {
    abstract public Identfication createIdentification();
    abstract public Storage createStorage();
    abstract public Display createDisplay();
    abstract public Controller createController();
    abstract public void create();
    abstract public void setWeightMeasurement(String name);
    abstract public String toString();

    public WeightMeasurement createWeightMeasurement(String name) {

        if(name.equalsIgnoreCase("LoadSensor"))
        {
            return new LoadSensor();
        }
        else if(name.equalsIgnoreCase("WeightModule"))
        {
            return new WeightModule();
        }

        return null;
    }

}
