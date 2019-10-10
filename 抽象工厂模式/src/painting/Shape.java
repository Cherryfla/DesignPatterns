package painting;

import java.awt.*;

public abstract class Shape {

    protected Color myColor;

    protected void setColor(Graphics g) {
        g.setColor(myColor);
    }

    abstract void draw(Graphics g);
}