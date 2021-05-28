package language;

import language.parser.CParser;
import language.parser.Parser;

public class C implements Language{

    Parser parser;

    C()
    {
        create();
    }

    @Override
    public Parser createParser() {
        return new CParser();
    }

    @Override
    public void create() {
        parser = createParser();
    }

    @Override
    public String toString() {
        return "C{" +
                "parser=" + parser +
                '}';
    }
}
