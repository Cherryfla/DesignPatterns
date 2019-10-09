package painting;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends Shape {

    private Point start;
    private Point end;

    Line(Point start, Point end, int color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    @Override
    void draw(Graphics g) {
        g.drawLine(start.x, start.y, end.x, end.y);
    }

}