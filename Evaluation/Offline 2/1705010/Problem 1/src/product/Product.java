package product;

import component.hardware.controller.Controller;
import component.hardware.display.Display;
import component.framework.Framework;
import component.hardware.identification.Identfication;
import component.internet.Internet;
import component.hardware.storage.Storage;
import component.hardware.weightmeasurement.WeightMeasurement;
import microcontroller.Microncontroller;
import teagaspackage.TeaGASPackage;

public class Product {

    TeaGASPackage teaGASPackage;
    Internet internet;
    Framework framework;

    public static Product getProduct(TeaGASPackage teaGASPackage, Internet internet, Framework framework)
    {
        Product p = new Product();

        p.teaGASPackage = teaGASPackage;

        if(teaGASPackage.getMicrocontrollerType().equals("ArduinoMega") || teaGASPackage.getMicrocontrollerType().equals("ATMega32"))
        {
            if(internet.toString().equals("Ethernet"))
            {
                return null;
            }
        }

        p.internet = internet;
        p.framework = framework;

        return p;
    }

    @Override
    public String toString() {
        return "Product{" +
                "teaGASPackage=" + teaGASPackage +
                ", internet=" + internet +
                ", framework=" + framework +
                '}';
    }
}
