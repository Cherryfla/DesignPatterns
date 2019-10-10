package painting;

import java.awt.*;

public class ShapeFactory {

   public static Shape creator(int choices, Point start, Point end) {

       if (choices == 1)
           return new Line(start, end, Color.black);
       else if (choices == 2)
           return new Circle(start, end, Color.black);
       else if (choices == 3)
           return new Rectangle(start, end, Color.black);
       else if (choices == 4)
           return new Rectangle(start, end, Color.white);
       else
           return null;
   }

}