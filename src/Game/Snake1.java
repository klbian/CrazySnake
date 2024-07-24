package Game;

import View.View_Double;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake1 extends Snake {
    public static boolean isLive1=true;

    public Snake1(Food food) {
        super(food, 20,20);
        isLive1=true;
    }

    public void keyboard(KeyEvent e) {                      //双人模式下的键盘按键
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                if (head.dir.equals(down)) {
                    break;
                }
                head.dir = up;
                break;
            case KeyEvent.VK_S:
                if (head.dir.equals(up)) {
                    break;
                }
                head.dir = down;
                break;
            case KeyEvent.VK_A:
                if (head.dir.equals(right)) {
                    break;
                }
                head.dir = left;
                break;
            case KeyEvent.VK_D:
                if (head.dir.equals(left)) {
                    break;
                }
                head.dir = right;
                break;
            default:
                break;
        }

    }

    public void move_double(Snake2 snake2) {
        addHead();
        if(this.getSnakeRectangle().intersects(food.getCoordinates())){
            score=score+10;
            food.repearShow();
        }else{
            deleteTail();
        }
        DeadOrLive_double(snake2);
    }

    public void DeadOrLive_double(Snake2 snake2) {                 //双人模式下的死亡判断
        if (head.row < 0 || head.row > rows - 1 || head.col < 0 || head.col > cols - 1) {
            isLive1 = false;
            View_Double.winner=2;
        }
        for (Node n = head.next; n != null; n = n.next) {
            if (n.col == head.col && n.row == head.row) {
                isLive1 = false;
                View_Double.winner=2;
            }
        }

        for (Node n =head.next;n!=null;n=n.next)
        {
            if (n.col==snake2.head.col && n.row==snake2.head.row){
                isLive1=false;
                View_Double.winner=1;
            }
        }

        if(head.row==snake2.head.row&&head.col==snake2.head.col){
            isLive1=false;
            View_Double.winner=3;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.pink);
        for (Node n = head; n != null; n = n.next) {
            n.draw(g);
            g.setColor(Color.white);
        }
    }
}
