package com.yd.util;

import javax.swing.*;
import java.awt.*;

/**
 * @PackageName: com.girlfriendhappy.util
 * @ClassName: CommonUtils
 * @Author: Royal
 * @Create: 2022-04-16 9:57
 * @Description:
 */
public class CommonUtils {
    /*
    读取图片资源.转化为Java对象,Image
     */
    public static Image getImage(String imgPath) {
        ImageIcon imageIcon = new ImageIcon(imgPath);
        return imageIcon.getImage();

    }
}
