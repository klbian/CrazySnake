package View;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

//主菜单界面
public class View_Home extends JLayeredPane {

    ImageIcon img = new ImageIcon("image/7.jpg");
    private Icon d = new ImageIcon("image/double.png");
    private Icon s = new ImageIcon("image/single.png");
    private Icon change = new ImageIcon("image/change.png");
    private Icon about = new ImageIcon("image/about.png");
    private Icon help = new ImageIcon("image/help.png");
    private Icon open = new ImageIcon("image/open.png");
    private Icon close = new ImageIcon("image/close.png");
    private Icon rank = new ImageIcon("image/rank.png");
    private Icon exit = new ImageIcon("image/exit.png");

    static JButton jb1 = new JButton("单人模式");
    static JButton jb2 = new JButton("双人模式");
    static JButton jb3 = new JButton("游戏帮助");
    static JButton jb4 = new JButton("切换音乐");
    static JButton jb5 = new JButton("音乐开关");
    static JButton jb6 = new JButton("关于游戏");
    static JButton jb7 = new JButton("排行榜");
    static JButton jb8 = new JButton("退出游戏");
    JLabel label = new JLabel(img);
    JLabel label2 = new JLabel();

    JPanel jp1 = new JPanel();          //放置背景图片的面板
    JPanel jp2 = new JPanel();          //放置文字的面板
    JPanel jp3 = new JPanel();          //放置按钮的面板
    JPanel jp4 = new JPanel();          //放置按钮的面板
    JPanel jp5 = new JPanel();

    public View_Home(){
        jp2.setOpaque(false);              //设置面板透明
        jp3.setOpaque(false);
        jp4.setOpaque(false);
        jp5.setOpaque(false);

        jp2.setLayout(null);               //设置面板布局
        jp3.setLayout(null);
        jp4.setLayout(null);
        jp5.setLayout(null);

        label2.setText("Crazy Snake");
        label2.setFont(new Font("Showcard Gothic",Font.BOLD,115));
        label2.setForeground(Color.yellow);

        jp1.setBounds(0,0,1280, 720);                //设置位置
        jp2.setBounds(0,0,1280,480);
        jp3.setBounds(0,480,1280,240);
        jp4.setBounds(960,0,320,720);
        jp5.setBounds(0,0,270,720);
        label.setBounds(0,0,1280, 720);
        label2.setBounds(250,0,800,290);

        jb1.setBounds(340,50,210,90);
        jb2.setBounds(740,50,210,90);
        jb3.setBounds(175,300,110,50);
        jb4.setBounds(20,300,110,50);
        jb5.setBounds(20,200,110,50);
        jb6.setBounds(175,400,110,50);
        jb7.setBounds(175,200,110,50);
        jb8.setBounds(175,640,110,50);

        jb1.setFont(new Font("隶书",Font.BOLD,25));
        jb1.setForeground(Color.white);
        jb2.setFont(new Font("隶书",Font.BOLD,25));
        jb2.setForeground(Color.white);
        jb3.setForeground(Color.white);
        jb4.setForeground(Color.white);
        jb5.setForeground(Color.white);
        jb6.setForeground(Color.white);
        jb7.setForeground(Color.white);
        jb8.setForeground(Color.white);

        jb1.setIcon(s);
        jb2.setIcon(d);
        jb3.setIcon(help);
        jb4.setIcon(change);
        jb5.setIcon(open);
        jb6.setIcon(about);
        jb7.setIcon(rank);
        jb8.setIcon(exit);

        jp1.add(label);
        jp2.add(label2);
        jp3.add(jb1);
        jp3.add(jb2);
        jp4.add(jb3);
        jp5.add(jb4);
        jp5.add(jb5);
        jp4.add(jb6);
        jp4.add(jb7);
        jp4.add(jb8);

        jb1.setHorizontalAlignment(SwingConstants.CENTER);
        jb2.setHorizontalAlignment(SwingConstants.CENTER);
        jb3.setHorizontalAlignment(SwingConstants.LEFT);
        jb4.setHorizontalAlignment(SwingConstants.LEFT);
        jb5.setHorizontalAlignment(SwingConstants.LEFT);
        jb6.setHorizontalAlignment(SwingConstants.LEFT);
        jb7.setHorizontalAlignment(SwingConstants.LEFT);
        jb8.setHorizontalAlignment(SwingConstants.LEFT);

        this.add(jp1,DEFAULT_LAYER);                 //设置图层位置
        this.add(jp2,MODAL_LAYER);
        this.add(jp3,MODAL_LAYER);
        this.add(jp4,MODAL_LAYER);
        this.add(jp5,MODAL_LAYER);
    }
    public static JButton getJb1() {
        return jb1;
    }               //获得按钮
    public static JButton getJb2() {
        return jb2;
    }
    public static JButton getJb3() {
        return jb3;
    }
    public static JButton getJb4() {
        return jb4;
    }
    public static JButton getJb5() {
        return jb5;
    }
    public static JButton getJb6() {
        return jb6;
    }
    public static JButton getJb7(){
        return jb7;
    }
    public static JButton getJb8(){
        return jb8;
    }
}
