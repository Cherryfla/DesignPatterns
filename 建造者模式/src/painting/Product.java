package painting;

import java.awt.*;
import java.util.Vector;

public class Product {
    Vector<Shape>parts = new Vector<Shape>();
    public void add(Shape part){
        parts.add(part);
    }
    public void show(Graphics g){
        for (int i = 0; i < parts.size(); i++) {
            parts.elementAt(i).draw(g);
        }
    }
}
