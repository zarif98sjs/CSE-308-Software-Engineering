package microcontroller;

import component.controller.Controller;
import component.display.Display;
import component.identification.Identfication;
import component.storage.Storage;

/*
* works as a component factory
* */
public interface Microncontroller {
    public Identfication createIdentification();
    public Storage createStorage();
    public Display createDisplay();
    public Controller createController();
}
