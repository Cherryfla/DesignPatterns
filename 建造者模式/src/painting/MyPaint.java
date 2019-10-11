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

    public static int flag = 0;
    // Constructor
    public MyPaint() {
        super("Drawing Program");

        // 定义画图区域
        drawingArea = new DrawPanel();
        drawingArea.construct();
        Container c = getContentPane();

        // 添加控件
        c.add(drawingArea, BorderLayout.CENTER);

        // 设置窗口
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width, height);
        setVisible(true);
    }
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
class DrawPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    // 用于保存图形
    private Product car;

    // Constructor
    public DrawPanel() {
        setBackground(Color.white);
    }

    public void construct(){
        Builder builder = new ConcreteBuilder();
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();

        car = builder.getResult();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        car.show(g);
    }
}