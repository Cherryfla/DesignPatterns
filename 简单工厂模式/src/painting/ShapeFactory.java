package painting;

import java.awt.Point;

public class ShapeFactory {

   public static Shape creator(int choices, Point start, Point end) {

       if (choices == 1)
           return new Line(start, end);
       else if (choices == 2)
           return new Circle(start, end);
       else if (choices == 3)
           return new Rectangle(start, end);
       else
           return null;
   }

}