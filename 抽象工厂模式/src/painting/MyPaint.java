package painting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

/**
 * @description 窗口类，定义大小以及窗口形态
 */
public class MyPaint extends JFrame {

    private DrawPanel drawingArea;
    private int width = 800, height = 600;

    public static ShapeFactory factory;
    public static int flag = 0;
    // Constructor
    public MyPaint() {
        super("Drawing Program");

        JToolBar buttonPanel; //按钮面板
        JButton solidTria = null, solidCircle = null, solidRect = null;
        JButton hollowTria = null, hollowCircle = null, hollowRect = null;
        JButton clear = null;

        /**
         * 按钮面板
         */
        buttonPanel = new JToolBar(JToolBar.HORIZONTAL);
        // 添加空心三角形按钮以及点击事件
        hollowTria = new JButton("HTriangle");
        hollowTria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                flag = 0;
                factory = new TriangleFactory();
            }});
        //添加实心三角形按钮以及点击事件
        solidTria = new JButton("STriangle");
        solidTria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                flag = 1;
                factory = new TriangleFactory();
            }});
        // 添加空心矩形按钮以及点击事件
        hollowRect = new JButton("HRectangle");
        hollowRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                flag = 0;
                factory = new RectangleFactory();
            }});
        //添加实心矩形按钮以及点击事件
        solidRect = new JButton("SRectangle");
        solidRect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                flag = 1;
                factory = new RectangleFactory();
            }});
        // 添加空心圆按钮以及点击事件
        hollowCircle = new JButton("HCircle");
        hollowCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                flag = 0;
                factory = new CircleFactory();
            }});
        //添加实心圆按钮以及点击事件
        solidCircle = new JButton("SCircle");
        solidCircle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                flag = 1;
                factory = new CircleFactory();
            }});
        //添加擦除按钮以及点击事件
        clear = new JButton("eraser");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                flag = 2;
                factory = new RectangleFactory();
            }
        });

        buttonPanel.add(solidTria);
        buttonPanel.add(hollowTria);
        buttonPanel.add(solidRect);
        buttonPanel.add(hollowRect);
        buttonPanel.add(solidCircle);
        buttonPanel.add(hollowCircle);
        buttonPanel.add(clear);

        // 定义画图区域
        drawingArea = new DrawPanel();
        Container c = getContentPane();

        // 添加控件
        c.add(drawingArea, BorderLayout.CENTER);
        c.add(buttonPanel, BorderLayout.NORTH);

        // 设置窗口
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);
    }

    /**
     * Main
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new MyPaint();

    }
}

/**
 * @description 画图面板类，提供鼠标监听器
 *
 */
class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {

    private static final long serialVersionUID = 1L;

    // 用于保存图形
    private Vector<Shape> shapes;

    // 用于记录鼠标画图时留下的两个点的坐标

    private int sx,sy,ex,ey;
    // Constructor
    public DrawPanel() {
        shapes = new Vector<>();
        setBackground(Color.white);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < shapes.size(); i++) {
            Shape tmp =  shapes.elementAt(i);
            draw(g, shapes.elementAt(i));
        }
    }
    void draw(Graphics g, Shape shape) {
        shape.draw(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(MyPaint.flag == 2) {
            int x = e.getX();
            int y = e.getY();
            shapes.add(MyPaint.factory.createSolid(new Point(x - 2, y - 2), new Point(x + 2, y + 2), Color.white));
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    //按下鼠标时记录坐标点
    @Override
    public void mousePressed(MouseEvent e) {
        sx = e.getX();
        sy = e.getY();
    }

    // 松开鼠标时记录坐标点并将图形画出来
    @Override
    public void mouseReleased(MouseEvent e) {
        ex = e.getX();
        ey = e.getY();
        if (MyPaint.flag == 0) {
            shapes.add(MyPaint.factory.createHollow(new Point(sx, sy), new Point(ex, ey), Color.black));
        }
        else if (MyPaint.flag == 1) {
            shapes.add(MyPaint.factory.createSolid(new Point(sx, sy), new Point(ex, ey), Color.black));
        }
        repaint();
    }

}