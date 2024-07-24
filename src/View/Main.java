package View;

import Date.Mysql;
import Date.Score;
import Game.Music;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//主窗口
public class Main extends JFrame {
    View_Home viewHome = new View_Home();

    public Main() {


        Music music1 =new Music("music/1.wav");       //音乐1
        Music music2 =new Music("music/2.wav");       //音乐2

        music2.stopMusic();
        this.setBounds(300, 100, 1280, 720);                                //设置窗口位置
        this.setResizable(false);
        this.setLayout(null);                                                                  //设置窗口布局

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayeredPane(viewHome);                                                           //放置主界面


        JButton single_mode = View_Home.getJb1();                                            //单人模式按钮
        single_mode.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_Login login = new View_Login();
                View_Register register = new View_Register();
                login.setVisible(true);
                register.setVisible(false);
                JButton b_login = View_Login.getJb1();
                JButton b_register = View_Login.getJb2();
                JButton b_ok = View_Register.getJb1();
                JButton b_return = View_Register.getJb2();
                Mysql m=new Mysql();
                b_login.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int flag=m.loginin();
                        if(flag!=-1){
                            String n = View_Login.getn();
                            login.dispose();
                            new Score(n);
                            View_Single viewSingle = new View_Single(n);
                            setLayeredPane(viewSingle);
                            setVisible(true);
                            setFocusable(true);
                            requestFocus();
                            viewSingle.requestFocusInWindow();
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"账号或密码错误!");
                        }
                    }
                });

                b_register.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        login.setVisible(false);
                        register.setVisible(true);
                    }
                });

                b_ok.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int flag=m.regist();
                        if(flag==1){
                            login.setVisible(true);
                            register.setVisible(false);
                        }
                    }
                });

                b_return.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        register.setVisible(false);
                        login.setVisible(true);

                    }
                });
            }
        });

        JButton double_mode = View_Home.getJb2();                                          //双人模式按钮
        double_mode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_Double viewDouble = new View_Double();
                setLayeredPane(viewDouble);
                setVisible(true);
                setFocusable(true);
                requestFocus();
                viewDouble.requestFocusInWindow();
            }
        });

        JButton single_return = View_Single.getJb4();                                     //单人模式返回主界面按钮
        single_return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_Single.SnakeThread_Single.stopThread();
                View_Home viewHome = new View_Home();
                setLayeredPane(viewHome);
                setVisible(true);
                viewHome.requestFocusInWindow();
            }
        });

        JButton double_return = View_Double.getJb4();                                       //双人模式返回主界面按钮
        double_return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_Double.SnakeThread.stopThread();
                View_Home viewHome = new View_Home();
                setLayeredPane(viewHome);
                setVisible(true);
                viewHome.requestFocusInWindow();
            }
        });

        JButton help =View_Home.getJb3();                                                  //帮助窗口按钮
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_Help view_help=new View_Help();
                setVisible(true);
                setFocusable(true);
                requestFocus();
                view_help.requestFocusInWindow();
            }
        });

        JButton changemusic =View_Home.getJb4();                                         //切换音乐按钮
        changemusic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Music.musicflag==1) {
                    music1.stopMusic();
                    music2.playMusic();
                    Music.r=true;
                    Music.musicflag=2;
                }
                else
                {
                    Music.musicflag=1;
                    music2.stopMusic();
                    music1.playMusic();
                    Music.r=true;
                }
            }
        });

        JButton music =View_Home.getJb5();                                             //音乐开关按钮
        Icon open = new ImageIcon("image/open.png");
        Icon close = new ImageIcon("image/close.png");
        music.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Music.musicflag==1)
                {
                    if(Music.r){
                        music1.stopMusic();
                        Music.r=false;
                        music.setIcon(close);
                    }
                    else {
                        music1.playMusic();
                        Music.r=true;
                        music.setIcon(open);
                    }
                }
                else {
                    if(Music.r){
                        music2.stopMusic();
                        Music.r=false;
                        music.setIcon(close);
                    }
                    else {
                        music2.playMusic();
                        Music.r=true;
                        music.setIcon(open);
                    }
                }
            }
        });

        JButton about =View_Home.getJb6();                                            //关于窗口按钮
        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_About view_about=new View_About();
                setVisible(true);
                setFocusable(true);
                requestFocus();
                view_about.requestFocusInWindow();
            }
        });

        JButton score = View_Home.getJb7();
        score.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                View_Score view_score = new View_Score();
                setVisible(true);
                setFocusable(true);
                requestFocus();
                view_score.requestFocusInWindow();
            }
        });

        JButton exit = View_Home.getJb8();
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );

        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        Main m = new Main();


    }                              //主函数



}


