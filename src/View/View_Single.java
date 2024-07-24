package View;

import Date.Score;
import Game.Food;
import Game.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//单人模式
public class View_Single extends JLayeredPane {
    String name;
    public static boolean isMove = true;     //判断是否游戏暂停
    public boolean moveflag=true;             //判断键盘监听是否获得内容的标志
    Food food = new Food();                    //创建食物
    Snake snake = new Snake(food,5,20);         //创建蛇
    SnakeThread_Single snakeThread = new SnakeThread_Single();         //创建线程
    ImageIcon img = new ImageIcon("image/3.jpg");

    JButton jb1 = new JButton("暂停");
    JButton jb2 = new JButton("继续");
    JButton jb3 = new JButton("重新开始");
    static JButton jb4 = new JButton("返回");

    JLabel label = new JLabel(img);
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();

    JLabel score = new JLabel("您当前得分："+ Snake.score);
    JLabel user = new JLabel("尊敬的用户："+View_Login.getn());
    JLabel highscore = new JLabel("<html>历史记录<br><br>您的历史最高分：<html>"+Score.highscore);

    public View_Single(String n){
        name=n;
        isMove=true;
        score.setFont(new Font("黑体",Font.BOLD,20));
        score.setForeground(Color.white);
        user.setFont(new Font("黑体",Font.BOLD,20));
        user.setForeground(Color.white);
        highscore.setFont(new Font("黑体",Font.BOLD,20));
        highscore.setForeground(Color.red);
        user.setBounds(20,0,270,120);

        score.setBounds(20,50,270,120);
        highscore.setBounds(20,150,270,120);
        label.setBounds(0,0,1280, 720);
        jb1.setBounds(80,340,100,50);
        jb2.setBounds(80,410,100,50);
        jb3.setBounds(80,480,100,50);
        jb4.setBounds(80,600,100,50);
        jp1.setBounds(0,0,1280, 720);
        jp2.setBounds(1000,0,280,720);

        jp1.add(label);
        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(score);
        jp2.add(user);
        jp2.add(highscore);
        jp2.setLayout(null);
        jp2.setOpaque(false);

        jb1.setForeground(Color.white);
        jb2.setForeground(Color.white);
        jb3.setForeground(Color.white);
        jb4.setForeground(Color.white);

        this.add(jp1,DEFAULT_LAYER);
        this.add(jp2,MODAL_LAYER);

        snakeThread.start();                                //启动线程

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {                       //键盘监听控制蛇移动
                if(moveflag==true) {                                             //通过加入布尔值让蛇每次移动只能获取一个按键
                    snake.keyboard(e);
                }
                moveflag=false;
            }
        });

        jb1.addActionListener(new ActionListener() {                           //暂停按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                isMove=false;
            }
        });

        jb2.addActionListener(new ActionListener() {                           //继续按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                isMove= true;
                setFocusable(true);
                requestFocus();
            }
        });

        jb3.addActionListener(new ActionListener() {                               //重新开始按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeThread.stopThread();                                           //让线程死亡
                food = new Food();
                snake=new Snake(food,5,20);
                Snake.islive=true;
                isMove=true;
                SnakeThread_Single st =new SnakeThread_Single();                      //新建一个线程
                snakeThread=st;
                st.start();
                setFocusable(true);
                requestFocus();
            }
        });
    }

    public static JButton getJb4()
    {
        return jb4;
    }                                  //获得返回按钮

    public void paint(Graphics g) {
        super.paint(g);
        snake.move();                              //蛇移动
        snake.draw(g);
        food.draw(g);
        moveflag=true;
    }

    public class SnakeThread_Single extends Thread{
        static boolean flag1 = true;

        public SnakeThread_Single(){
            flag1=true;
        }
        @Override
        public void run() {

            while(Snake.islive &&flag1){
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(Snake.islive&&isMove){
                    repaint();
                    score.setText("您当前得分："+ Snake.score);
                }
            }
            if(Snake.islive==false){//游戏结束结果判断
                View_Score.showe();
                if(Snake.score> Score.highscore)
                {
                    JOptionPane.showMessageDialog(View_Single.this, "恭喜您打破了历史记录！");
                }
                else {
                    JOptionPane.showMessageDialog(View_Single.this, "游戏结束");
                }
                new Score(name);
                highscore.setText("<html>历史记录<br><br>您的历史最高分：<html>"+Score.highscore);
                flag1=false;
            }
        }
        public static void stopThread(){
            flag1=false;
        }
    }
}

