package Date;

import Game.Snake;

import java.sql.*;

public class Score {
    PreparedStatement ps=null;
    Connection ct=null;
    ResultSet rs=null;
    public static int highscore;
    public static String highuser;
    public static String user;

    public Score(String n){
        user=n;
        try {
            String USER="root";
            String PASS="winner.123";
            Class .forName("com.mysql.cj.jdbc.Driver");
            ct= DriverManager.getConnection("jdbc:mysql://localhost:3306/game?user="+USER+"&password="+PASS + "&useUnicode=true&characterEncoding=gbk&useSSL=false&serverTimezone=GMT");
            if(highscore< Snake.score){
                ps=ct.prepareStatement("update user_t set highscore =?,time=curdate() where name =?");
                ps.setInt(1, Snake.score);
                ps.setString(2,user);
                ps.executeUpdate();
            }

            ps=ct.prepareStatement("select highscore from user_t where name=?");
            ps.setString(1, user);
            rs=ps.executeQuery();
            while (rs.next()){
                highscore=rs.getInt(1);

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

    }
}
