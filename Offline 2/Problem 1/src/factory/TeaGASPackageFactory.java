package factory;

import teagaspackage.*;

public class TeaGASPackageFactory extends TeaGASPackageAbstractFactory {

    public TeaGASPackage getTeaGASPackage(String name)
    {
        if(name.equalsIgnoreCase("silver")) {
            return new Silver();
        }
        else if(name.equalsIgnoreCase("gold")) {
            return new Gold();
        }
        else if(name.equalsIgnoreCase("diamond")) {
            return new Diamond();
        }
        else if(name.equalsIgnoreCase("platinum")) {
            return new Platinum();
        }

        return null;
    }

}
