package painting;

import java.awt.*;

public class Circle extends Shape {

    private Point start;
    private Point end;

    public Circle(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.myColor = color;
    }

    @Override
    void draw(Graphics g) {
        setColor(g);
        int x = Math.min(start.x,end.x);
        int y = Math.min(start.y,end.y);
        int width =  Math.abs(start.x - end.x);
        int height = Math.abs(start.y - end.y);
        g.drawOval(x,y,width,height);
    }

}
