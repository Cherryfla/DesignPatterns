package painting;

import java.awt.*;

public class Line extends Shape {

    private Point start;
    private Point end;

    Line(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.myColor = color;
    }

    @Override
    void draw(Graphics g) {
        setColor(g);
        g.drawLine(start.x, start.y, end.x, end.y);
    }

}