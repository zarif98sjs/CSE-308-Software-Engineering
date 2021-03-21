package language;

import language.parser.Parser;

public interface Language {
    public String toString();
    public Parser createParser();
    public void create();
}
