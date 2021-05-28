package component.internet;


public class InternetFactory{

    public static Internet getInternet(String name) {

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
