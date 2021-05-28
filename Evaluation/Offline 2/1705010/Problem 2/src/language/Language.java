package language;

import language.parser.Parser;

/*
* Language Factory
* */

public interface Language {
    public String toString();
    public Parser createParser();
    public void create();
}
