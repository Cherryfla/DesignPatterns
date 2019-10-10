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
    public static int choices = 1;

    // Constructor
    public MyPaint() {
        super("Drawing Program");

        JToolBar buttonPanel; //按钮面板
        JButton line = null, circle = null, rect = null, clear = null;

        /**
         * 按钮面板
         */
        buttonPanel = new JToolBar(JToolBar.HORIZONTAL);
        // 添加直线按钮以及点击事件
        line = new JButton("Line");
        line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                choices = 1;
            }});

        // 添加圆按钮以及点击事件
        circle = new JButton("Circle");
        circle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                choices = 2;
            }});

        // 添加矩形按钮以及点击事件
        rect = new JButton("Rectangle");
        rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                choices = 3;
            }});
        //添加擦除按钮以及点击事件
        clear = new JButton("eraser");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
                choices = 4;
            }
        });

        buttonPanel.add(line);
        buttonPanel.add(circle);
        buttonPanel.add(rect);
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
        if (MyPaint.choices == 4) {
            int x = e.getX();
            int y = e.getY();
            shapes.add(ShapeFactory.creator(MyPaint.choices, new Point(x - 2, y - 2), new Point(x + 2, y + 2)));
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
        if(MyPaint.choices <= 3) {
            shapes.add(ShapeFactory.creator(MyPaint.choices, new Point(sx, sy), new Point(ex, ey)));
            repaint();
        }
    }

}