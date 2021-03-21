package teagaspackage;

public class TeaGASPackageFactory {

    public static TeaGASPackage getTeaGASPackage(String name)
    {
        TeaGASPackage t;

        if(name.equalsIgnoreCase("silver")) {
            t = new Silver();
            t.create();
            return t;
        }
        else if(name.equalsIgnoreCase("gold")) {
            t = new Gold();
            t.create();
            return t;
        }
        else if(name.equalsIgnoreCase("diamond")) {
            t = new Diamond();
            t.create();
            return t;
        }
        else if(name.equalsIgnoreCase("platinum")) {
            t = new Platinum();
            t.create();
            return t;
        }

        return null;
    }
}
