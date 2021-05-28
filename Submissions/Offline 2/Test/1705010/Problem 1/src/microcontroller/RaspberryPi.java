package microcontroller;

import component.hardware.controller.BuiltInController;
import component.hardware.controller.Controller;
import component.hardware.display.Display;
import component.hardware.display.TouchScreen;
import component.hardware.identification.Identfication;
import component.hardware.identification.NFC;
import component.hardware.storage.BuiltInStorage;
import component.hardware.storage.Storage;
import component.hardware.weightmeasurement.WeightMeasurement;

public class RaspberryPi extends Microncontroller {

    Identfication identfication;
    Storage storage;
    Display display;
    Controller controller;
    WeightMeasurement weightMeasurement;

    @Override
    public Identfication createIdentification() {
        return new NFC();
    }

    @Override
    public Storage createStorage() {
        return new BuiltInStorage();
    }

    @Override
    public Display createDisplay() {
        return new TouchScreen();
    }

    @Override
    public Controller createController() {
        return new BuiltInController();
    }

    public void setWeightMeasurement(String name)
    {
        weightMeasurement = createWeightMeasurement(name);
    }

    @Override
    public void create()
    {
        identfication = createIdentification();
        storage = createStorage();
        display = createDisplay();
        controller = createController();
    }

    @Override
    public String toString() {
        return "RaspberryPi{" +
                "identfication=" + identfication +
                ", storage=" + storage +
                ", display=" + display +
                ", controller=" + controller +
                ", weightMeasurement=" + weightMeasurement +
                '}';
    }
}
