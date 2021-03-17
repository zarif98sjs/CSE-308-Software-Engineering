package product;

import component.controller.Controller;
import component.display.Display;
import component.framework.Framework;
import component.identification.Identfication;
import component.internet.Internet;
import component.storage.Storage;
import component.weightmeasurement.WeightMeasurement;
import microcontroller.Microncontroller;
import teagaspackage.Silver;
import teagaspackage.TeaGASPackage;

public class Product {

    TeaGASPackage teaGASPackage;
    Internet internet;
    Framework framework;

    Microncontroller microncontroller;
    WeightMeasurement weightMeasurement;

    Identfication identfication;
    Storage stroage;
    Display display;
    Controller controller;


    public Product(TeaGASPackage teaGASPackage, Internet internet, Framework framework)
    {
        this.teaGASPackage = teaGASPackage;
        this.internet = internet;
        this.framework = framework;

        this.microncontroller = this.teaGASPackage.createMicrocontroller();
        this.weightMeasurement = this.teaGASPackage.createWeightMeasurement();

        identfication = microncontroller.createIdentification();
        stroage = microncontroller.createStorage();
        display = microncontroller.createDisplay();
        controller = microncontroller.createController();
    }

    @Override
    public String toString() {
        return "Product{" +
                "teaGASPackage=" + teaGASPackage +
                ", internet=" + internet +
                ", framework=" + framework +
                ", microncontroller=" + microncontroller +
                ", weightMeasurement=" + weightMeasurement +
                ", identfication=" + identfication +
                ", stroage=" + stroage +
                ", display=" + display +
                ", controller=" + controller +
                '}';
    }
}
