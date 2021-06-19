package com.company;

import mediator.JCC;
import service.*;

public class Wrapper {

    JCC jcc;
    JPDC jpdc;
    JRTA jrta;
    JRTC jrtc;
    JWSA jwsa;

    Wrapper()
    {
        jcc = new JCC();
        jpdc = new JPDC(jcc);
        jrta = new JRTA(jcc);
        jrtc = new JRTC(jcc);
        jwsa = new JWSA(jcc);
    }

    void process(String first,String second) {
        if (second.equals("SERVE")) {

            Service service = null;

            if (first.equals("JPDC")) service = jpdc.serveRequest();
            else if (first.equals("JRTA")) service = jrta.serveRequest();
            else if (first.equals("JRTC")) service = jrtc.serveRequest();
            else if (first.equals("JWSA")) service = jwsa.serveRequest();

            System.out.println(first + " serves the request of "+service);

        } else {

            if (second.equals("POWER")) {

                if (first.equals("JPDC")) System.out.println("Can't request itself");
                else if (first.equals("JRTA")) jpdc.recieveRequest(new JRTA(jcc));
                else if (first.equals("JRTC")) jpdc.recieveRequest(new JRTC(jcc));
                else if (first.equals("JWSA")) jpdc.recieveRequest(new JWSA(jcc));

                if (!first.equals("JPDC")) System.out.println(first+" requests for POWER service");

            } else if (second.equals("TRANSPORT")) {

                if (first.equals("JPDC")) jrta.recieveRequest(new JPDC(jcc));
                else if (first.equals("JRTA")) System.out.println("Can't request itself");
                else if (first.equals("JRTC")) jrta.recieveRequest(new JRTC(jcc));
                else if (first.equals("JWSA")) jrta.recieveRequest(new JWSA(jcc));

                if (!first.equals("JRTA")) System.out.println(first+" requests for TRANSPORT service");

            } else if (second.equals("TELECOM")) {

                if (first.equals("JPDC")) jrtc.recieveRequest(new JPDC(jcc));
                else if (first.equals("JRTA")) jrtc.recieveRequest(new JRTA(jcc));
                else if (first.equals("JRTC")) System.out.println("Can't request itself");
                else if (first.equals("JWSA")) jrtc.recieveRequest(new JWSA(jcc));

                if (!first.equals("JRTC")) System.out.println(first+" requests for TELECOM service");

            } else if (second.equals("WATER")) {

                if (first.equals("JPDC")) jwsa.recieveRequest(new JPDC(jcc));
                else if (first.equals("JRTA")) jwsa.recieveRequest(new JRTA(jcc));
                else if (first.equals("JRTC")) jwsa.recieveRequest(new JRTC(jcc));
                else if (first.equals("JWSA")) System.out.println("Can't request itself");

                if (!first.equals("JWSA")) System.out.println(first+" requests for WATER service");

            }
        }
    }
}
