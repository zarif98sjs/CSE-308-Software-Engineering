package microcontroller;

import component.hardware.identification.Identfication;

public class TestMicro {


    public static void main(String[] args) {
        Microncontroller m = new ATMega32();
        Identfication id = m.createIdentification();
        System.out.println(id.toString());
    }
}
