package aesthetics;

import aesthetics.color.Blue;
import aesthetics.color.Color;
import aesthetics.font.CourierNew;
import aesthetics.font.Font;
import aesthetics.style.Normal;
import aesthetics.style.Style;

public class CAesthetics implements Aesthetics {

    Font font;
    Style style;
    Color color;

    CAesthetics()
    {
        create();
    }

    @Override
    public Font createFont() {
        return new CourierNew();
    }

    @Override
    public Style createStyle() {
        return new Normal();
    }

    @Override
    public Color createColor() {
        return new Blue();
    }

    @Override
    public void create() {
        font = createFont();
        style = createStyle();
        color = createColor();
    }

    @Override
    public String toString() {
        return "CAesthetics{" +
                "font=" + font +
                ", style=" + style +
                ", color=" + color +
                '}';
    }
}
