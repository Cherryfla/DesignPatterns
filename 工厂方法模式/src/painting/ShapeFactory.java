package painting;

import java.awt.*;

public abstract class ShapeFactory {
    public abstract Shape creator(Point start, Point end, Color color);
}

class LineFactory extends ShapeFactory{

    @Override
    public Shape creator(Point start, Point end, Color color) {
        return new Line(start, end, color);
    }
}

class RectangleFactory extends ShapeFactory{

    @Override
    public Shape creator(Point start, Point end, Color color) {
        return new Rectangle(start, end, color);
    }
}

class CircleFactory extends ShapeFactory{

    @Override
    public Shape creator(Point start, Point end, Color color) {
        return new Circle(start, end, color);
    }
}
