# my-game
闲来无事,逛CSDN时看到一个有意思的java小项目(PS:绝对不是因为博主的女朋友好看!!!)

```
版权声明：本文为CSDN博主「yui方木」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_44976835/article/details/109719479
```

## 1.搭建

依次搭建GameClient,Heart,People,Flower,Balloon等类的项目构成。

这几个类参数分别有xy坐标高度宽度，游戏控制台类型的参数gameClient。people类参数还有speed（速度），dir（控制移动方向），装heart类型的哈希表heartlists。

```java
    private int x;
    private int y;//x,y坐标
    private int width;//图片高度
    private int height;//图片宽度
    private GameClient gameClient;//游戏控制台参数
    private int speed;//人物移动速度
    private String dir;//方向控制
    private List<Heart> heartLists = new ArrayList<>();//Heart类型的哈希表

```

其中x,y:控制Windows界面的坐标轴.

![xy坐标轴](D:\工具\Typora\文档\我的娱乐\my-game\xy坐标轴.png)
