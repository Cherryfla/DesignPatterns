package painting;

import java.awt.*;

public class SolidRectangle extends Shape {

   private Point start;
   private Point end;

   public SolidRectangle(Point start, Point end, Color color) {
       this.start = start;
       this.end = end;
       this.myColor = color;
   }

   @Override
   void draw(Graphics g) {
       this.setColor(g);
       g.fillRect(Math.min(start.x, end.x), Math.min(start.y, end.y),
               Math.abs(start.x - end.x), Math.abs(start.y - end.y));
   }
}