package View;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JLayeredPane.DEFAULT_LAYER;
import static javax.swing.JLayeredPane.MODAL_LAYER;

//帮助窗口
public class View_Help extends JDialog {
    JLayeredPane jLayeredPane = new JLayeredPane();    //分层面板
    JLabel jLabel2 = new JLabel();               //放置文字的标签
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JPanel jp2 = new JPanel();                 //放置标签的面板
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    JScrollPane js = null;

    public View_Help(){
        this.setAlwaysOnTop(true);              //设置子窗口属性
        this.setTitle("游戏帮助");
        this.setBounds(600,300,500,500);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        jLabel2.setText("游戏玩法");
        jLabel3.setText("<html><br>———————单人模式——————————<br><br>在本模式中，您可以通过 ↑ ↓ ← → 来控制<br>小蛇移动。<br>您可以通过捕食食物增长自己的身体，同<br>时可以获得一定的分数。<br>您的目标是获取更高的分数！<br>注意：<br>不要碰到墙壁！！！不要咬到自己！！！<br><br>—————————————————————<br><br><br><br>———————双人模式—————————<br><br>在本模式中，玩家一可以通过 W S A D 来<br>控制小蛇移动；<br>玩家二可以通过 ↑ ↓ ← → 来控制小蛇移动；<br>您可以通过捕食食物增长自己的身体。<br>您的目标是消灭对方取得胜利！<br>提示：对方撞到墙壁或您身上都会失败，<br>所以尽可能的让自己变长，围困对方，取<br>得胜利！！！<br><br>—————————————————————</html>");

        jLabel2.setFont(new Font("站酷小薇LOGO体",Font.BOLD,35));
        jLabel3.setFont(new Font("站酷小薇LOGO体",Font.PLAIN,26));

        jLabel2.setForeground(Color.yellow);
        jLabel3.setForeground(Color.white);

        jp2.add(jLabel2);
        jp2.setBounds(0,0,500,50);

        js= new JScrollPane(jLabel3);
        js.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        js.setBounds(0,45,500,413);
        js.setVisible(true);
        jLayeredPane.add(jp2,MODAL_LAYER);                        //文字放上层
        jLayeredPane.add(js,DEFAULT_LAYER);
        js.setOpaque(false);
        this.setContentPane(jLayeredPane);
        }
}
