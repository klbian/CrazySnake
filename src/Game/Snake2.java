package Game;

import View.View_Double;

import java.awt.*;

public class Snake2 extends Snake{
    public static boolean isLive2=true;
    public Snake2(Food food) {
        super(food, 20,30);
        isLive2=true;
    }

    public void move_double(Snake1 snake1) {
        addHead();
        if(this.getSnakeRectangle().intersects(food.getCoordinates())){
            score=score+10;
            food.repearShow();
        }else{
            deleteTail();
        }
        DeadOrLive_double(snake1);
    }

    public void DeadOrLive_double(Snake1 snake1) {             //双人模式下的死亡判断
        if (head.row < 0 || head.row > rows - 1 || head.col < 0 || head.col > cols - 1) {
            isLive2 = false;
            View_Double.winner=1;
        }
        for (Node n = head.next; n != null; n = n.next) {
            if (n.col == head.col && n.row == head.row) {
                isLive2 = false;
                View_Double.winner=1;
            }
        }
        for (Node n =head.next;n!=null;n=n.next)
        {
            if (n.col==snake1.head.col && n.row==snake1.head.row){
                isLive2=false;
                View_Double.winner=2;
            }
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.cyan);
        for (Node n = head; n != null; n = n.next) {
            n.draw(g);
            g.setColor(Color.green);
        }
    }
}
