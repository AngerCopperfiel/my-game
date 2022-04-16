package com.yd.main;

import com.yd.util.CommonUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @PackageName: com.girlfriendhappy
 * @ClassName: GameClient
 * @Author: Royal
 * @Create: 2022-04-15 20:37
 * @Description:
 */
public class GameClient extends Frame {
    //定义背景图
    public static final String BG_PATH = "img/背景图.png";
    //声明属性image
    private static final Image image;

    //人物图像的
    private final People people;
    //定义爱心的坐标
    private final Heart heart ;
    //定义多个鲜花的坐标,大小
    private final Flower flower_v1 ;
    private final Flower flower_v2 ;
    private final Flower flower_v3 ;
    private final Flower flower_v4 ;
    private final Flower flower_v5 ;
    private final Flower flower_v6 ;
    //气球
    private final Balloon balloon ;

    public GameClient() {
        //定义人物图像的坐标
        people = new People(400, 300, this);
        //定义爱心的坐标
        heart = new Heart(1050, 400, this);
        //定义多个鲜花的坐标,大小
        flower_v1 = new Flower(300, 800, 50, 50, this);
        flower_v2 = new Flower(1050, 100, 50, 50, this);
        flower_v3 = new Flower(350, 350, 50, 50, this);
        flower_v4 = new Flower(800, 100, 50, 50, this);
        flower_v5 = new Flower(500, 560, 50, 50, this);
        flower_v6 = new Flower(600, 350, 50, 50, this);
        //气球
        balloon = new Balloon(150, 600, this);
    }
    //加载一次背景资源
   static {
       image = CommonUtils.getImage(BG_PATH);
   }
    //画方法
    public void paint(Graphics g) {
        //画背景
        g.drawImage(image, 0, 0, 1440, 1080, this);
        //画人物
        people.paint(g);
        //画爱心
        heart.paint(g);
        //画花
        flower_v1.paint(g);
        flower_v2.paint(g);
        flower_v3.paint(g);
        flower_v4.paint(g);
        flower_v5.paint(g);
        flower_v6.paint(g);
        //画气球
        balloon.paint(g);
    }
    //开始方法
    public void start() {
        //设置标题
        this.setTitle("老婆大人");
        //设置窗体大小以及边界
        this.setBounds(0,0,1440,1080);
        //关闭游戏窗口
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Game over");
                System.exit(0);
            }
        });
        //监听键盘事件
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int KeyCode = e.getKeyCode();
                people.okDirPressed(KeyCode);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                int KeyCode = e.getKeyCode();
                people.okDirReleased(KeyCode);
                people.setDir("STOP");
            }
        });
        //显示窗体
        this.setVisible(true);
        /*
        线程创建部分
         */
        RepaintThread repaintThread = new RepaintThread(this);
        //创建线程
        Thread thread = new Thread(repaintThread);
        //调用游戏开始方法
        thread.start();
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        GameClient gameClient = new GameClient();
        frame.setLocationRelativeTo(null);
        gameClient.addNotify();
        gameClient.start();
    }
}

