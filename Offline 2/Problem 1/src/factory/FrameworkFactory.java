package factory;

import component.framework.Django;
import component.framework.Framework;
import component.framework.Laravel;
import component.framework.Spring;
import component.internet.Ethernet;
import component.internet.GSM;
import component.internet.WiFi;

public class FrameworkFactory extends FrameworkAbstractFactory{

    @Override
    public Framework getFramework(String name) {

        if(name.equalsIgnoreCase("django")) {
            return new Django();
        }
        else if(name.equalsIgnoreCase("laravel")) {
            return new Laravel();
        }
        else if(name.equalsIgnoreCase("spring")) {
            return new Spring();
        }

        return null;
    }
}
