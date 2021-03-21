package language;

import language.parser.CPPParser;
import language.parser.CParser;
import language.parser.Parser;

public class CPP implements Language{

    Parser parser;

    CPP()
    {
        create();
    }

    @Override
    public Parser createParser() {
        return new CPPParser();
    }

    @Override
    public void create() {
        parser = createParser();
    }

    @Override
    public String toString() {
        return "CPP{" +
                "parser=" + parser +
                '}';
    }
}
