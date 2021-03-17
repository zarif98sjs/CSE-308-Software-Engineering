package factory;

import component.internet.Ethernet;
import component.internet.GSM;
import component.internet.Internet;
import component.internet.WiFi;


public class InternetFactory extends InternetAbstractFactory{

    @Override
    public Internet getInternet(String name) {

        if(name.equalsIgnoreCase("ethernet")) {
            return new Ethernet();
        }
        else if(name.equalsIgnoreCase("gsm")) {
            return new GSM();
        }
        else if(name.equalsIgnoreCase("wifi")) {
            return new WiFi();
        }

        return null;
    }
}
