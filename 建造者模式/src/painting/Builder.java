package painting;

import java.awt.*;

public abstract class Builder {
    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();
    public abstract Product getResult();
}

class ConcreteBuilder extends Builder{
    private Product product = new Product();
    @Override
    public void buildPartA(){
        Shape A1 = new Circle(new Point(100, 100), new Point(125,125), Color.black);
        Shape A2 = new Circle(new Point(150, 100), new Point(175,125), Color.black);
        product.add(A1);
        product.add(A2);
    }

    @Override
    public void buildPartB(){
        Shape B = new Rectangle(new Point(80, 80), new Point(195, 100), Color.black);
        product.add(B);
    }

    @Override
    public void buildPartC(){
        Shape C = new Triangle(new Point(175, 60), new Point(195,80), Color.black);
        product.add(C);
    }

    @Override
    public Product getResult(){
        return product;
    }
}

