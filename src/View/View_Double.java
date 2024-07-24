package View;

import Game.Food;
import Game.Snake2;
import Game.Snake1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static Game.Snake.islive;

//双人模式
public class View_Double extends JLayeredPane {
    public static int winner = 0;                             //判断获胜方
    public static boolean isMove = true;                      //判断游戏是否暂停
    Food food = new Food();                                   //创建食物
    Snake2 snake2 = new Snake2(food);                          //创建蛇1
    Snake1 snake1 = new Snake1(food);                          //创建蛇2
    SnakeThread snakeThread = new SnakeThread();               //创建一个线程
    ImageIcon img = new ImageIcon("image/3.jpg");

    JButton jb1 = new JButton("暂停");
    JButton jb2 = new JButton("继续");
    JButton jb3 = new JButton("重新开始");
    static JButton jb4 = new JButton("返回");

    JLabel label = new JLabel(img);
    JLabel jLabel= new JLabel("<html>消灭对方<br>获得胜利<html>");

    JPanel jPanel = new JPanel();                         //放置背景图片的面板
    JPanel jp2 = new JPanel();                             //放置按钮的面板

    public View_Double(){
        jLabel.setFont(new Font("黑体",Font.BOLD,40));
        jLabel.setForeground(Color.red);

        jp2.setBounds(1000,0,270,720);
        jPanel.setBounds(0,0,1280, 720);
        label.setBounds(0,0,1280, 720);
        jLabel.setBounds(50,50,270,300);
        jb1.setBounds(80,340,100,50);
        jb2.setBounds(80,410,100,50);
        jb3.setBounds(80,480,100,50);
        jb4.setBounds(80,600,100,50);

        jp2.add(jb1);
        jp2.add(jb2);
        jp2.add(jb3);
        jp2.add(jb4);
        jp2.add(jLabel);
        jp2.setLayout(null);
        jp2.setOpaque(false);
        jPanel.add(label);

        jb1.setForeground(Color.white);
        jb2.setForeground(Color.white);
        jb3.setForeground(Color.white);
        jb4.setForeground(Color.white);

        this.add(jPanel,DEFAULT_LAYER);                              //将背景放置下层
        this.add(jp2,MODAL_LAYER);                                   //将其他东西放上层

        snakeThread.start();                                      //启动线程

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent a) {                      //添加按键监听，控制蛇移动
                snake1.keyboard(a);
                snake2.keyboard(a);
            }
        });

        jb1.addActionListener(new ActionListener() {                     //暂停按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                isMove=false;
            }
        });

        jb2.addActionListener(new ActionListener() {                      //继续按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                isMove= true;
                setFocusable(true);
                requestFocus();
            }
        });

        jb3.addActionListener(new ActionListener() {                      //重新开始按钮监听
            @Override
            public void actionPerformed(ActionEvent e) {
                snakeThread.stopThread();                                  //让线程死亡
                food = new Food();
                snake2 =new Snake2(food);
                snake1 =new Snake1(food);
                Snake2.isLive2=true;
                Snake1.isLive1=true;
                isMove=true;
                SnakeThread st =new SnakeThread();                         //创建新线程
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
    }                    //获得返回按钮

    public void paint(Graphics g) {
        super.paint(g);
        snake2.move_double(snake1);                                     //蛇移动
        snake1.move_double(snake2);                                     //蛇移动
        snake2.draw(g);
        snake1.draw(g);
        food.draw(g);
    }

    public class SnakeThread extends Thread{
        static boolean flag = true;
        public SnakeThread(){
          flag=true;
      }
        @Override
        public void run() {
            while(Snake1.isLive1 &&Snake2.isLive2&&flag){
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                if(Snake1.isLive1&&Snake2.isLive2&&isMove){                           //蛇存活且没有暂停则重绘画面
                    repaint();
                }
            }
            if(Snake1.isLive1==false|| Snake2.isLive2==false){                         //游戏结束后的结果判定
                if(winner==1)
                {
                    JOptionPane.showMessageDialog(View_Double.this, "恭喜玩家一白蛇获胜！");
                }
                else if(winner==2)
                {
                    JOptionPane.showMessageDialog(View_Double.this, "恭喜玩家二青蛇获胜！");
                }
                else
                {
                    JOptionPane.showMessageDialog(View_Double.this, "你们同归于尽了！");
                }
                flag=false;
            }
        }
        public static void stopThread(){
            flag=false;
        }
    }
}

