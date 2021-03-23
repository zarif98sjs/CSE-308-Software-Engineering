package teagaspackage;

import microcontroller.Microncontroller;

public interface TeaGASPackage {

    public String createName();
    public Microncontroller createMicrocontroller();
    public String getMicrocontrollerType();
    public void create();

}
