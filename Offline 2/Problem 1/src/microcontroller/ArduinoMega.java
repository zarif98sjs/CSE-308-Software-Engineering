package microcontroller;

import component.controller.AddOnController;
import component.controller.Controller;
import component.display.Display;
import component.display.LCD;
import component.identification.Identfication;
import component.identification.RFID;
import component.storage.SDCard;
import component.storage.Storage;

public class ArduinoMega implements Microncontroller {
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

    @Override
    public String toString() {
        return "ArduinoMega";
    }
}
