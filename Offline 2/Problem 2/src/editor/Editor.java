package editor;

import aesthetics.Aesthetics;
import aesthetics.AestheticsFactory;
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
            instance.language = LanguageFactory.getLanguage("C");
            instance.aesthetics = AestheticsFactory.getAesthetics("C");
        }
        else if(name.equalsIgnoreCase("cpp")){
            instance.language = LanguageFactory.getLanguage("CPP");
            instance.aesthetics = AestheticsFactory.getAesthetics("CPP");

        }
        else if(name.equalsIgnoreCase("python")){
            instance.language = LanguageFactory.getLanguage("Python");
            instance.aesthetics = AestheticsFactory.getAesthetics("Python");
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
