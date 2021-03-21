package com.company;

import component.framework.Framework;
import component.internet.Internet;
import component.framework.FrameworkFactory;
import component.internet.InternetFactory;
import product.Product;
import teagaspackage.TeaGASPackage;
import teagaspackage.TeaGASPackageFactory;

public class Main {

    public static void main(String[] args) {
	// write your code here

        TeaGASPackage t = TeaGASPackageFactory.getTeaGASPackage("Diamond");
        Internet internet = InternetFactory.getInternet("gsm");
        Framework framework = FrameworkFactory.getFramework("django");

        Product p = new Product(t,internet,framework);
        System.out.println(p);

    }
}
