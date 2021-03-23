package com.company;

import component.framework.Framework;
import component.internet.Internet;
import component.framework.FrameworkFactory;
import component.internet.InternetFactory;
import product.Product;
import teagaspackage.TeaGASPackage;
import teagaspackage.TeaGASPackageFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        System.out.println("Choose Package : Silver , Gold , Diamond , Platinum");
        String package_type = sc.next();

        System.out.println("Choose Internet Type : WiFi , Ethernet , GSM");
        String internet_type = sc.next();

        System.out.println("Choose Framework : Django , Spring , Laravel");
        String framework_type = sc.next();

        TeaGASPackage teaGASPackage = TeaGASPackageFactory.getTeaGASPackage(package_type);
        Internet internet = InternetFactory.getInternet(internet_type);
        Framework framework = FrameworkFactory.getFramework(framework_type);

        Product p = Product.getProduct(teaGASPackage,internet,framework);

        if(p != null)
        {
            System.out.println(p);
        }
        else
        {
            System.out.println("Your microcontroller doesn't support this internet type");
        }

    }
}
