package language;

import language.parser.CPPParser;
import language.parser.Parser;
import language.parser.PythonParser;

public class Python implements Language{
    Parser parser;

    Python()
    {
        create();
    }

    @Override
    public Parser createParser() {
        return new PythonParser();
    }

    @Override
    public void create() {
        parser = createParser();
    }

    @Override
    public String toString() {
        return "Python{" +
                "parser=" + parser +
                '}';
    }
}
