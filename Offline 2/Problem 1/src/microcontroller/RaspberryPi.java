package microcontroller;

import component.controller.BuiltInController;
import component.controller.Controller;
import component.display.Display;
import component.display.TouchScreen;
import component.identification.Identfication;
import component.identification.NFC;
import component.storage.BuiltInStorage;
import component.storage.Storage;

public class RaspberryPi implements Microncontroller {
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

    @Override
    public String toString() {
        return "RaspberryPi";
    }
}
