package aesthetics;

import aesthetics.color.Color;
import aesthetics.font.Font;
import aesthetics.style.Style;

/*
* Abstract Abstract Factory
* */

public interface Aesthetics {
    public String toString();
    public Font createFont();
    public Style createStyle();
    public Color createColor();
    public void create();
}
