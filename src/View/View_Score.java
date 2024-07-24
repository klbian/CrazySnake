package View;

import Date.Score;
import Game.Snake;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class View_Score extends JDialog {
    static JLabel jl1 = new JLabel();
    static JLabel jl2 = new JLabel();
    static JLabel jl3 = new JLabel();
    static JLabel jl4 = new JLabel();
    static JLabel jl5 = new JLabel();
    JLayeredPane jLayeredPane = new JLayeredPane();
    JScrollPane js =null;
    static JTable table =null;
    private Vector<Vector<Object>> rowData = new Vector<Vector<Object>>();
    static SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    PreparedStatement ps=null;
    Connection ct=null;
    ResultSet rs=null;

    public View_Score(){
        Vector<Object> columnNames=new Vector<Object>();
        columnNames.add("玩家");
        columnNames.add("最高得分");
        columnNames.add("时间");

        try {
            String USER="root";
            String PASS="winner.123";
            Class .forName("com.mysql.cj.jdbc.Driver");
            ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/game?user="+USER+"&password="+PASS + "&useUnicode=true&characterEncoding=gbk&useSSL=false&serverTimezone=GMT");
            ps=ct.prepareStatement("select name,highscore,time from user_t order by highscore desc;");
            rs=ps.executeQuery();
            while(rs.next()){
                Vector<Object> hang = new Vector<Object>();
                hang.add(rs.getString(1));
                hang.add(rs.getInt(2));
                hang.add(rs.getString(3));
                rowData.add(hang);
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally{
            try {
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
                if(ct!=null){
                    ct.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
        tcr.setHorizontalAlignment(JLabel.CENTER);// 这句和上句作用一样
        table=new JTable(rowData,columnNames);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//只允许选中一行
        table.setDefaultRenderer(Object.class, tcr);
        table.setVisible(true);
        js= new JScrollPane(table);
        js.setVisible(true);

        this.setAlwaysOnTop(true);              //设置子窗口属性
        this.setTitle("排行榜");
        this.setBounds(600,300,500,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.add(js,BorderLayout.CENTER);

    }

    public static void showe(){
        if (!Snake.islive)
        {
            jl5.setText(jl4.getText());
            jl4.setText(jl3.getText());
            jl3.setText(jl2.getText());
            jl2.setText(jl1.getText());
            jl1.setText(Score.user + "      " + Snake.score+"      "+sdf.format(System.currentTimeMillis()));
        }
    }
}
