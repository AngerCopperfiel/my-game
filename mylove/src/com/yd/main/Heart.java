package com.yd.main;

import com.yd.util.CommonUtils;

import java.awt.*;

/**
 * @PackageName: com.girlfriendhappy
 * @ClassName: Heart
 * @Author: Royal
 * @Create: 2022-04-15 20:34
 * @Description:
 */
////爱心类
public class Heart {
    private int x;
    private int y;//x,y坐标
    private int width;//图片高度
    private int height;//图片宽度
    private GameClient gameClient;//游戏控制台参数
    private int speed;//爱心移动速度
    //传入爱心图片
    public static final Image HEART_IMAGE = CommonUtils.getImage("img/爱心.jpg");

    public Heart() {
    }
    public void paint(Graphics g) {
        g.drawImage(HEART_IMAGE, this.x, this.y, this.width, this.height, this.gameClient);
    }
    public Heart(int x, int y, GameClient gameClient) {
        this.x = x;
        this.y = y;
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

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
