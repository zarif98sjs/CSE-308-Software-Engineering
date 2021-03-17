package com.company;

import component.framework.Django;
import component.framework.Framework;
import component.internet.GSM;
import component.internet.Internet;
import factory.FrameworkFactory;
import factory.InternetAbstractFactory;
import factory.InternetFactory;
import product.Product;
import teagaspackage.TeaGASPackage;
import factory.TeaGASPackageFactory;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TeaGASPackageFactory teaGASPackageFactory = new TeaGASPackageFactory();
        InternetFactory internetFactory = new InternetFactory();
        FrameworkFactory frameworkFactory = new FrameworkFactory();

        TeaGASPackage t = teaGASPackageFactory.getTeaGASPackage("Diamond");
        Internet internet = internetFactory.getInternet("gsm");
        Framework framework = frameworkFactory.getFramework("django");

        Product p = new Product(t,internet,framework);
        System.out.println(p);

    }
}
