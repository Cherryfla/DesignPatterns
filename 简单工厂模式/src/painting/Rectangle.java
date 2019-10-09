package painting;

import java.awt.Graphics;
import java.awt.Point;

public class Rectangle extends Shape {

   private Point start;
   private Point end;

   public Rectangle(Point start, Point end) {
       this.start = start;
       this.end = end;
   }

   @Override
   void draw(Graphics g) {
       g.drawRect(Math.min(start.x, end.x), Math.min(start.y, end.y),
               Math.abs(start.x - end.x), Math.abs(start.y - end.y));
   }

}