package painting;

import java.awt.*;

public class Rectangle extends Shape {

   private Point start;
   private Point end;

   public Rectangle(Point start, Point end, Color color) {
       this.start = start;
       this.end = end;
       this.myColor = color;
   }

   @Override
   void draw(Graphics g) {
       this.setColor(g);
       if (myColor == Color.white)
           g.fillRect(Math.min(start.x, end.x), Math.min(start.y, end.y),
                   Math.abs(start.x - end.x), Math.abs(start.y - end.y));
       else
            g.drawRect(Math.min(start.x, end.x), Math.min(start.y, end.y),
                    Math.abs(start.x - end.x), Math.abs(start.y - end.y));
   }

}