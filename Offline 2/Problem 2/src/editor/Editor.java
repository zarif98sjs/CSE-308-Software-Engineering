package editor;

import aesthetics.Aesthetics;
import aesthetics.AestheticsStaticFactory;
import language.*;

public class Editor {

    private static Editor instance;
    Language language;
    Aesthetics aesthetics;

    private Editor() {}

    public static Editor getInstance()
    {
        if(instance == null){
            instance = new Editor();

        }
        return instance;
    }

    public void setLanguage(String name)
    {
        if(name.equalsIgnoreCase("c")){
            instance.language = LanguageStaticFactory.getLanguage("C");
            instance.aesthetics = AestheticsStaticFactory.getAesthetics("C");
        }
        else if(name.equalsIgnoreCase("cpp")){
            instance.language = LanguageStaticFactory.getLanguage("CPP");
            instance.aesthetics = AestheticsStaticFactory.getAesthetics("CPP");

        }
        else if(name.equalsIgnoreCase("python")){
            instance.language = LanguageStaticFactory.getLanguage("Python");
            instance.aesthetics = AestheticsStaticFactory.getAesthetics("Python");
        }
    }

    @Override
    public String toString() {
        return "Editor{" +
                "language=" + language +
                ", aesthetics=" + aesthetics +
                '}';
    }
}
