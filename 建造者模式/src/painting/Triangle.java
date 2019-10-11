package painting;

import java.awt.*;

public class Triangle extends Shape {

    private Point start;
    private Point end;

    Triangle(Point start, Point end, Color color) {
        this.start = start;
        this.end = end;
        this.myColor = color;
    }

    @Override
    void draw(Graphics g) {
        setColor(g);
        //   g.drawLine(start.x, start.y, end.x, end.y);
        int[] xs = {start.x, start.x ,end.x};
        int[] ys = {start.y, end.y, end.y};

        g.drawPolygon(xs, ys, 3);
    }

}