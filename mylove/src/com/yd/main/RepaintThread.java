package com.yd.main;

/**
 * @PackageName: com.yd.main
 * @ClassName: RepaintThread
 * @Author: Royal
 * @Create: 2022-04-16 15:49
 * @Description:
 */
//画面刷新类
public class RepaintThread implements Runnable{
    private GameClient gameClient;

    public RepaintThread() {
    }

    public RepaintThread(GameClient gameClient) {
        this.gameClient = gameClient;
    }
    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
                gameClient.repaint();
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
