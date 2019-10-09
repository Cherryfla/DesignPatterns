package painting;
import java.awt.Graphics;
import java.awt.Point;

public class Circle extends Shape {

    private Point start;
    private Point end;

    public Circle(Point start, Point end, int color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }

    @Override
    void draw(Graphics g) {
    	int x = Math.min(start.x,end.x);
    	int y = Math.min(start.y,end.y);
        int width =  Math.abs(start.x - end.x);
        int height = Math.abs(start.y - end.y);
        g.drawOval(x,y,width,height);

    }

}
//椭圆
//int width =  Math.max(Math.abs(start.x), Math.abs(start.y - end.y));   	//??
//int height = Math.max(Math.abs(start.x - end.x), Math.abs(start.y - end.y));
