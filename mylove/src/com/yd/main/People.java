package com.yd.main;

import com.yd.util.CommonUtils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName: com.girlfriendhappy
 * @ClassName: People
 * @Author: Royal
 * @Create: 2022-04-15 20:33
 * @Description:
 */
//移动的人物类
public class People {
    private int x;
    private int y;//x,y坐标
    private int width;//图片高度
    private int height;//图片宽度
    private GameClient gameClient;//游戏控制台参数
    private int speed;//人物移动速度
    private String dir;//方向控制
    private List<Heart> heartLists = new ArrayList<>();//Heart类型的哈希表
    //传入人物图片
    public static final Image RENWU_IMAGE = CommonUtils.getImage("img/我的女神.png");

    //People类中定义的paint方法
    //Graphics图形类
    public void paint(Graphics g) {
        g.drawImage(RENWU_IMAGE, this.x, this.y, this.width, this.height, this.gameClient);
    }

    //键盘控制属性
    boolean UP = false;
    boolean DOWN = false;
    boolean LEFT = false;
    boolean RIGHT = false;
    boolean CONTROL = false;//控制增加爱心
    //增加爱心的方法
    public Heart createHeart() {
        return new Heart(this.x,this.y,this.gameClient);
    }

    /*
    键盘监听器
     */
    //控制松开键盘
    public void okDirReleased(int KeyCode) {
        switch(KeyCode) {
            case KeyEvent.VK_UP:
                UP = false;
                break;
            case KeyEvent.VK_DOWN:
                DOWN = false;
                break;
            case KeyEvent.VK_LEFT:
                LEFT = false;
                break;
            case KeyEvent.VK_RIGHT:
                RIGHT = false;
                break;
            case KeyEvent.VK_CONTROL:
                CONTROL = false;
                break;
        }
    }
    //接收我们按下键盘的指令
    public void okDirPressed(int KeyCode) {
        switch(KeyCode) {
            case KeyEvent.VK_UP:
                System.out.println("向上走");
                String dir = "UP";
                UP = true;
                this.setDir(dir);
                break;
            case KeyEvent.VK_DOWN:
                System.out.println("向下走");
                DOWN = true;
                this.setDir("DOWN");
                break;
            case KeyEvent.VK_LEFT:
                System.out.println("向左走");
                LEFT = true;
                this.setDir("LEFT");
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("向右走");
                RIGHT = true;
                this.setDir("RIGHT");
                break;
            case KeyEvent.VK_CONTROL:
                System.out.println("放置爱心");
                Heart heart = this.createHeart();
                //将爱心放入容器中()
                this.heartLists.add(heart);
                CONTROL = true;
                this.setDir("CONTROL");

                //看容器中还有多少爱心
                System.out.println("爱心数量"+this.heartLists.size());
                break;
        }
        //判断左上左下右上右下
        if(UP&&RIGHT) {
            this.setDir("UR");
        }
        if(UP&&LEFT) {
            this.setDir("UL");
        }
        if(DOWN&&RIGHT) {
            this.setDir("DR");
        }
        if(DOWN&&LEFT) {
            this.setDir("DL");
        }
        this.move(this.getDir());
    }

    //move方法,控制图片移动
    public void move(String dir) {
        if("UP".equals(dir)) {
            this.y-=this.speed;
        }
        if("DOWN".equals(dir)) {
            this.y+=this.speed;
        }
        if("LEFT".equals(dir)) {
            this.x-=this.speed;
        }
        if("RIGHT".equals(dir)) {
            this.x+=this.speed;
        }
        if("UR".equals(dir)) {
            this.y-=this.speed;
            this.x+=this.speed;
        }
        if("UL".equals(dir)) {
            this.y-=this.speed;
            this.x-=this.speed;
        }
        if("DR".equals(dir)) {
            this.y+=this.speed;
            this.x+=this.speed;
        }
        if("DL".equals(dir)) {
            this.y+=this.speed;
            this.x-=this.speed;
        }
    }
    //构造器
    public People() {
    }

    public People(int x, int y, GameClient gameClient) {
        this.x = x;
        this.y = y;
        this.gameClient = gameClient;
    }
    //get和set方法
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public GameClient getGameClient() {
        return gameClient;
    }

    public void setGameClient(GameClient gameClient) {
        this.gameClient = gameClient;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public List<Heart> getHeartLists() {
        return heartLists;
    }

    public void setHeartLists(List<Heart> heartLists) {
        this.heartLists = heartLists;
    }
}
