package language;

public class LanguageFactory {

    public static Language getLanguage(String name)
    {
        if(name.equalsIgnoreCase("C"))
        {
            return new C();
        }
        else if(name.equalsIgnoreCase("CPP"))
        {
            return new CPP();
        }
        else if(name.equalsIgnoreCase("Python"))
        {
            return new Python();
        }

        return null;
    }
}