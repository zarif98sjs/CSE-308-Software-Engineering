package microcontroller;

import component.hardware.controller.AddOnController;
import component.hardware.controller.Controller;
import component.hardware.display.Display;
import component.hardware.display.LCD;
import component.hardware.identification.Identfication;
import component.hardware.identification.RFID;
import component.hardware.storage.SDCard;
import component.hardware.storage.Storage;
import component.hardware.weightmeasurement.WeightMeasurement;

public class ArduinoMega extends Microncontroller {

    Identfication identfication;
    Storage storage;
    Display display;
    Controller controller;
    WeightMeasurement weightMeasurement;

    @Override
    public Identfication createIdentification() {
        return new RFID();
    }

    @Override
    public Storage createStorage() {
        return new SDCard();
    }

    @Override
    public Display createDisplay() {
        return new LCD();
    }

    @Override
    public Controller createController() {
        return new AddOnController();
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
        return "ArduinoMega{" +
                "identfication=" + identfication +
                ", storage=" + storage +
                ", display=" + display +
                ", controller=" + controller +
                ", weightMeasurement=" + weightMeasurement +
                '}';
    }
}
