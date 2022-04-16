package com.yd.main;

import com.yd.util.CommonUtils;

import java.awt.*;

/**
 * @PackageName: com.girlfriendhappy
 * @ClassName: Flower
 * @Author: Royal
 * @Create: 2022-04-15 20:36
 * @Description:
 */
//花朵类
public class Flower {
    private int x;
    private int y;//x,y坐标
    private int width;//图片高度
    private int height;//图片宽度
    private GameClient gameClient;//游戏控制台参数
    //传入花图片
    public static final Image FLOWER_IMAGE = CommonUtils.getImage("img/玫瑰花.jpg");

    public Flower() {
    }
    //Flower类中定义的paint方法
    public void paint(Graphics g) {
        g.drawImage(FLOWER_IMAGE, this.x, this.y, this.width, this.height, this.gameClient);
    }
    public Flower(int x, int y, int width, int height, GameClient gameClient) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameClient = gameClient;
    }

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
}
