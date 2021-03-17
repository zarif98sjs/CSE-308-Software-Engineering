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

    public Product(TeaGASPackage teaGASPackage, Internet internet, Framework framework)
    {
        this.teaGASPackage = teaGASPackage;
        this.internet = internet;
        this.framework = framework;
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
