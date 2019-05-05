package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


import javax.swing.JFrame;
import javax.swing.JPanel;
class SnakeComponent extends JPanel
{

    private static final long serialVersionUID = 1L;

    private Rectangle2D[][] squares; // 所有网络
    private int[][] sign;               //  网格状态标记 0网格 1食物 2蛇身
    private Deque<Pair> snake ;         //蛇身
    private Pair food;                  //食物位置
    private int direction = 0;          //方向 1 左 2 右 3 上 4 下
    private int status = 0;             //状态 0结束 1运行 2暂停
    private int level = 3; // 难度等级 3初级 2中级 1高级
    private Timer timer; // 定时器
    private final int WIDTH_SIZE = 100; // 横向格子数
    private final int HEIGHT_SIZE = 60; // 纵向格子数
    private final int SNAKE_TYPE = 2; // 蛇身
    private final int FOOD_TYPE = 1; // 食物
    private final int AREA_TYPE = 0; // 网格
    private final int KEY_LEFT = 1; // 左
    private final int KEY_RIGHT = 2; // 右
    private final int KEY_UP = 3; // 上
    private final int KEY_DOWN = 4; // 下

    public SnakeComponent()
    {
        sign = new int[WIDTH_SIZE][HEIGHT_SIZE];
        squares = new Rectangle2D[WIDTH_SIZE][HEIGHT_SIZE];
        ;
    }
    public void init() {
        //getContentPane
     //   setBackground(Color.red);
        //this.getContentPane();
        sign = new int[WIDTH_SIZE][HEIGHT_SIZE];
        squares = new Rectangle2D[WIDTH_SIZE][HEIGHT_SIZE];
        int swidth = getWidth();
        int sheight = getHeight();      
        double pwidth = 1.0 * swidth / WIDTH_SIZE;
        double pheight = 1.0 * sheight / HEIGHT_SIZE;
        for (int i = 0; i < WIDTH_SIZE; i++) {
            for (int j = 0; j < HEIGHT_SIZE; j++) {
                sign[i][j] = AREA_TYPE;
                squares[i][j] = new Rectangle2D.Double(i * pwidth, j * pheight, pwidth, pheight);                    
            }        
        }

        snake = new LinkedList<Pair>();
        repaint();
        addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (status == 1) {
                     changeDiretion(e.getKeyCode());
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {
				System.out.println("此次输入的是“" + e.getKeyChar() + "”");// 获得输入的字符
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String keyText = KeyEvent.getKeyText(e.getKeyCode());// 获得描述keyCode的标签
				System.out.println("您释放的是“" + keyText + "”键");
				System.out.println();
            }
        });
       // setVisible(true);
    }
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        for(int i=0;i<squares.length;++i)
        {
            for(int j=0;j<squares[i].length;++j)
            {
            if(sign[i][j]==FOOD_TYPE)
            {
                g2.setColor(Color.red);
            }
            else if(sign[i][j]==SNAKE_TYPE)
            {
                g2.setColor(Color.blue);
            }
            else 
            {
                g2.setColor(Color.white);
            }
           // System.out.println(squares[i][j]);
            if(status==1)
            g2.fill(squares[i][j]);
          /// g2.draw(squares[i][j]);
        
            }
        }
    }

    public void startGame()
    {
        status=1;  
        init();
             
/*        TimerTask task = new TimerTask() { 
         
            @Override   
            public void run() {     
                actionPerformed(null);
            } 
    
        };
        timer.schedule(task, 1000);*/
    }

    public void actionPerformed(ActionEvent arg0)
    {
        Pair head=snake.getFirst();
        int i=head.i;
        int j=head.j;
        switch(direction)
        {
            case 1: i+=1;break;
            case 2: i-=1;break;
            case 3: j-=1;break;
            case 4: j+=1;break;
            default: return;
        }
        if(i<0 || i>=WIDTH_SIZE || j<0 || j>=HEIGHT_SIZE || sign[i][j] == SNAKE_TYPE)
        {
            // timer.stop();
            timer=null;
            status=0;
            // String message="你的"+ scoreLabel.getText()+",是否提交？";
            // int ret=JOptionPane.showConfirmDialog(snakeCompoent, message, "游戏结束", JOptionPane.YES_NO_OPTION);
            //  if(ret == JOptionPane.YES_OPTION)
            //  {
            //      saveScore();
            //  }
            return;
        }
        sign[i][j]=SNAKE_TYPE;
        snake.addFirst(new Pair(i,j));
        if(i !=food.i || j !=food.j)
        {
            Pair tail=snake.pollLast();
            sign[tail.i][tail.j]=AREA_TYPE;
        }
        else
        {
            //  scoreLabel.setText("得分："+(snake.size()-1));
            Random r=new Random();
            do{
                int fi=r.nextInt(WIDTH_SIZE);
                int fj=r.nextInt(HEIGHT_SIZE);
                if(sign[fi][fj] == AREA_TYPE)
                {
                    sign[fi][fj]=FOOD_TYPE;
                    food=new Pair(fi,fj);
                    break;
                }
            }while(true);
        }
        repaint();
    }

    public void changeDiretion (int getKeyCode) {       //重写要实现的按下按键的方法
        int key = getKeyCode;                 //获取按下按键的虚拟码(int类型）
        if (key == KeyEvent.VK_UP) {              //与按键的虚拟码进行比较，是按下哪个按键
            direction=KEY_UP;
            System.out.println("up");               //向上箭头
        }
        else if (key == KeyEvent.VK_DOWN) {       //向下箭头   
            direction=KEY_DOWN;
            System.out.println("down");
        }
        else if (key == KeyEvent.VK_LEFT) {
            direction=KEY_LEFT;
            System.out.println("left");
        }
        else if (key == KeyEvent.VK_RIGHT) {
            direction=KEY_RIGHT;
            System.out.println("right");
        }
        else {System.out.println("invalid input");}
    }

    /**
     * @return the squares
     */
    public Rectangle2D[][] getSquares() {
        return squares;
    }

    /**
     * @param squares the squares to set
     */
    public void setSquares(Rectangle2D[][] squares) {
        this.squares = squares;
    }

    /**
     * @return the sign
     */
    public int[][] getSign() {
        return sign;
    }

    /**
     * @param sign the sign to set
     */
    public void setSign(int[][] sign) {
        this.sign = sign;
    }

    /**
     * @return the snake
     */
    public Deque<Pair> getSnake() {
        return snake;
    }

    /**
     * @param snake the snake to set
     */
    public void setSnake(Deque<Pair> snake) {
        this.snake = snake;
    }

    /**
     * @return the food
     */
    public Pair getFood() {
        return food;
    }

    /**
     * @param food the food to set
     */
    public void setFood(Pair food) {
        this.food = food;
    }

    /**
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(int direction) {
        this.direction = direction;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * @param timer the timer to set
     */
    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    /**
     * @return the wIDTH_SIZE
     */
    public int getWIDTH_SIZE() {
        return WIDTH_SIZE;
    }

    /**
     * @return the hEIGHT_SIZE
     */
    public int getHEIGHT_SIZE() {
        return HEIGHT_SIZE;
    }

    /**
     * @return the sNAKE_TYPE
     */
    public int getSNAKE_TYPE() {
        return SNAKE_TYPE;
    }

    /**
     * @return the fOOD_TYPE
     */
    public int getFOOD_TYPE() {
        return FOOD_TYPE;
    }

    /**
     * @return the aREA_TYPE
     */
    public int getAREA_TYPE() {
        return AREA_TYPE;
    }

    /**
     * @return the kEY_LEFT
     */
    public int getKEY_LEFT() {
        return KEY_LEFT;
    }

    /**
     * @return the kEY_RIGHT
     */
    public int getKEY_RIGHT() {
        return KEY_RIGHT;
    }

    /**
     * @return the kEY_UP
     */
    public int getKEY_UP() {
        return KEY_UP;
    }

    /**
     * @return the kEY_DOWN
     */
    public int getKEY_DOWN() {
        return KEY_DOWN;
    }
 
    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

}
