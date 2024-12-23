package View;

import javax.swing.*;
import java.awt.*;

import static javax.swing.JLayeredPane.DEFAULT_LAYER;
import static javax.swing.JLayeredPane.MODAL_LAYER;

//关于窗口
public class View_About extends JDialog {
    //ImageIcon img = new ImageIcon("image/1.jpg");
    JLayeredPane jLayeredPane = new JLayeredPane();           //分层面板
    //JLabel jLabel = new JLabel(img);                          //放置图片的标签
    JLabel jLabel2 = new JLabel();                            //放置文字的标签
    JPanel jp2 = new JPanel();                           //放置标签的面板

    public View_About(){
        this.setAlwaysOnTop(true);                            //设置子窗口的属性
        this.setTitle("关于游戏");
        this.setBounds(600,300,500,500);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        jLabel2.setText("<html><br>游戏名称：Crazy Snake<br><br>版本：　　3.2.0<br><br>更新时间：2023年5月7日<br><br>作者姓名：边凯伦<br><br>联系方式：15153398750<br><br><html>");
        jLabel2.setFont(new Font("宋体",Font.BOLD,30));
        jLabel2.setForeground(Color.LIGHT_GRAY);

        jp2.add(jLabel2);

        //jLabel.setBounds(0,0,500,500);
        jp2.setBounds(0,0,500,500);

        //jLayeredPane.add(jLabel,DEFAULT_LAYER);                  //将背景图片放底层
        jLayeredPane.add(jp2,MODAL_LAYER);                    //将文字面板放上层
        jp2.setOpaque(false);                               //文字背景透明

        this.setContentPane(jLayeredPane);
    }
}
