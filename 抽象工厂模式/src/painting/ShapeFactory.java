package painting;

import java.awt.*;

public abstract class ShapeFactory {
    public abstract Shape createSolid(Point start, Point end, Color color);
    public abstract Shape createHollow(Point start, Point end, Color color);
}

class TriangleFactory extends ShapeFactory{

    @Override
    public Shape createSolid(Point start, Point end, Color color) {
        return new SolidTriangle(start, end, color);
    }

    @Override
    public Shape createHollow(Point start, Point end, Color color) {
        return new HollowTriangle(start, end, color);
    }

}

class RectangleFactory extends ShapeFactory{

    @Override
    public Shape createSolid(Point start, Point end, Color color) {
        return new SolidRectangle(start, end, color);
    }

    @Override
    public Shape createHollow(Point start, Point end, Color color) {
        return new HollowRectangle(start, end, color);
    }

}

class CircleFactory extends ShapeFactory{

    @Override
    public Shape createSolid(Point start, Point end, Color color) {
        return new SolidCircle(start, end, color);
    }

    @Override
    public Shape createHollow(Point start, Point end, Color color) {
        return new HollowCircle(start, end, color);
    }

}
