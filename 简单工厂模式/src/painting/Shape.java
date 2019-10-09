package painting;

import java.awt.Graphics;

public abstract class Shape {
    protected int color;
    abstract void draw(Graphics g);
    int getColor(){
        return color;
    };
}