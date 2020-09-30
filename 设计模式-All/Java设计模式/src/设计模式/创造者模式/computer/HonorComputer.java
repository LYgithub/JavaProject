package 设计模式.创造者模式.computer;

import javax.swing.*;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式.computer
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class HonorComputer extends Computer {
    @Override
    public void setOs() {
        mOs = "麒麟";
    }
}
