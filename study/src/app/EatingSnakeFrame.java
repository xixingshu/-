package app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class EatingSnakeFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel leftPanel;       //左边区域
    private JPanel rightPanel;      //右边区域
    private JLabel scoreLabel;      //得分
    private SnakeComponent snakeComponent;  //游戏区
  //  private JLabel snakeComponent;  //游戏区
    private JPanel btnPanel;         //按钮容器
    private JButton startButtom;    //开始
    private JButton suspendButton;  //暂停
    private JButton stopButton;     //停止
    private ButtonGroup levelSelect;//级别选择
    private JRadioButton normalRB;  //初级难度
    private JRadioButton middleRB;  //中级难度
    private JRadioButton hardRB;    //高级难度
    private JTextArea rankInfo;     //排行榜
    //frame size
    private int height;
    private int width;

    public EatingSnakeFrame() {
        
        setTitle("贪吃蛇");
        height=420;
        width=600;
        setSize(width,height);          //设置大小 
        setLocationByPlatform(true);    //设置定位

        setLayout(null);
        leftPanel=new JPanel();
        leftPanel.setLayout(null);
        leftPanel.setSize(500,420);
        leftPanel.setLocation(0,0);

        scoreLabel=new JLabel("得分：0");
        scoreLabel.setLocation(0,0);
        scoreLabel.setSize(500,30);

        snakeComponent=new SnakeComponent();
      //  snakeComponent=new JLabel();
        snakeComponent.setLocation(0,30);
        snakeComponent.setSize(500,360);
        
        leftPanel.add(scoreLabel);
        leftPanel.add(snakeComponent);
        add(leftPanel);

        rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        rightPanel.setSize(100,420);
        rightPanel.setLocation(500,0);

        btnPanel=new JPanel();
        btnPanel.setLayout(new GridLayout(6,1));

        startButtom = new JButton("开始");
        startButtom.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){            
                snakeComponent.startGame();
                System.out.println("123444");
                snakeComponent.requestFocus();
            }
        });
        
        suspendButton = new JButton("暂停");
        suspendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                if(snakeComponent.getStatus() !=0)
                {
                    if(suspendButton.getText()=="暂停")
                    {
                        
                    }
                }
            }
        });

        stopButton = new JButton("停止");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                ;
            }
        });

        normalRB = makeRadioButton("初级",true,3);
        middleRB = makeRadioButton("中级",false,2);
        hardRB = makeRadioButton("高级",false,1);
        levelSelect = new ButtonGroup();
        levelSelect.add(normalRB);
        levelSelect.add(middleRB);
        levelSelect.add(hardRB);
        btnPanel.add(startButtom);
        btnPanel.add(suspendButton);
        btnPanel.add(stopButton);
        btnPanel.add(normalRB);
        btnPanel.add(middleRB);
        btnPanel.add(hardRB);
        rightPanel.add(btnPanel,BorderLayout.NORTH);

        rankInfo = new JTextArea();
        rankInfo.setEditable(false);
        rankInfo.setBackground(Color.gray);
        rightPanel.add(rankInfo,BorderLayout.CENTER);
        add(rightPanel);

        setVisible(true);
    }

    private JRadioButton makeRadioButton(String name, boolean selected, final int level) {
        JRadioButton bt=new JRadioButton(name,selected);
        bt.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    snakeComponent.setLevel(level);
                //    snakeComponent.requestFocus();
                ;
                }
            });
        return bt;
    }
}


