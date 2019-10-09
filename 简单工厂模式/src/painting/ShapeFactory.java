package painting;

import java.awt.Point;

public class ShapeFactory {

   public static Shape creator(int choices, Point start, Point end) {

       if (choices == 1)
           return new Line(start, end, 1);
       else if (choices == 2)
           return new Circle(start, end, 1);
       else if (choices == 3)
           return new Rectangle(start, end, 1);
       else if (choices == 4)
           return new Rectangle(start, end, 0);
       else
           return null;
   }

}