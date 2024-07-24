package Date;

import View.View_Login;
import View.View_Register;

import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class Mysql {
    private Vector<Vector<Object>> rowData = new Vector<Vector<Object>>();
    static SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    PreparedStatement ps=null;
    Connection ct=null;
    ResultSet rs=null;

    public int loginin(){
        int h=-1;
        try {
            String USER="root";
            String PASS="winner.123";
            Class .forName("com.mysql.cj.jdbc.Driver");
            ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/game?user="+USER+"&password="+PASS + "&useUnicode=true&characterEncoding=gbk&useSSL=false&serverTimezone=GMT");
            ps=ct.prepareStatement("select highscore from user_t where name=? and password=?");
            ps.setString(1,View_Login.getn());
            ps.setString(2,View_Login.getp());
            rs=ps.executeQuery();
            while (rs.next()){
                h=rs.getInt(1);

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
        return h;
    }

    public int regist(){
        int a=0;
        try {
            String USER="root";
            String PASS="winner.123";
            Class .forName("com.mysql.cj.jdbc.Driver");
            ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/game?user="+USER+"&password="+PASS + "&useUnicode=true&characterEncoding=gbk&useSSL=false&serverTimezone=GMT");
            ps=ct.prepareStatement("insert into user_t(name,password) values('" + View_Register.getn() + "','" + View_Register.getp() + "')");
            a=ps.executeUpdate();
            if(a == 1){
                JOptionPane.showMessageDialog(null,"注册成功！");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"对不起，该用户名已被注册！");
            e.printStackTrace();
        } finally{
            try {

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
        return a;
    }
}
