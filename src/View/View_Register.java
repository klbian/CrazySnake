package View;

import javax.swing.*;
import java.awt.*;
import static javax.swing.JLayeredPane.MODAL_LAYER;

//注册窗口
public class View_Register extends JDialog {
    JLayeredPane jLayeredPane = new JLayeredPane();
    JLabel jl1,jl2;
    public  static JTextField jtf1;
    public static JPasswordField jps;
    static JButton jb1,jb2;

    public View_Register(){
        this.setTitle("注册");
        this.setVisible(true);
        this.setSize(320,190);
        this.setLocation(750,300);
        jl1=new JLabel("用户名：");
        jl2=new JLabel("密码：");
        jl1.setHorizontalAlignment(JLabel.CENTER);
        jl2.setHorizontalAlignment(JLabel.CENTER);

        jtf1=new JTextField(20);
        jps=new JPasswordField(20);
        jps.setEchoChar('●');
        jb1=new JButton("注册");
        jb2=new JButton("返回");

        jLayeredPane.add(jl1,MODAL_LAYER);
        jLayeredPane.add(jtf1);
        jLayeredPane.add(jl2);
        jLayeredPane.add(jps);
        jLayeredPane.add(jb1);
        jLayeredPane.add(jb2);

        this.setLayout(null);
        jl1.setBounds(45,10,50,30);
        jl2.setBounds(45,50,50,30);
        jtf1.setBounds(95,10,150,30);
        jps.setBounds(95,50,150,30);
        jb1.setBounds(60,110,80,30);
        jb2.setBounds(170,110,80,30);

        this.add(jLayeredPane);
        this.setContentPane(jLayeredPane);
    }
    public static JButton getJb1() {
        return jb1;
    }

    public static JButton getJb2() {
        return jb2;
    }

    public static String getn(){
        return jtf1.getText();
    }

    public static String getp(){
        return jps.getText();
    }

}
