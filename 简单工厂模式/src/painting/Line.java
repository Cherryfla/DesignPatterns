package painting;

import java.awt.Graphics;
import java.awt.Point;

public class Line extends painting.Shape {

    private Point start;
    private Point end;

    Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    @Override
    void draw(Graphics g) {
        g.drawLine(start.x, start.y, end.x, end.y);
    }

}