package aesthetics;

public class AestheticsStaticFactory {

    public static Aesthetics getAesthetics(String name)
    {
        if(name.equalsIgnoreCase("C"))
        {
            return new CAesthetics();
        }
        else if(name.equalsIgnoreCase("CPP"))
        {
            return new CPPAesthetics();
        }
        else if(name.equalsIgnoreCase("Python"))
        {
            return new PythonAesthetics();
        }
        return null;
    }
}
