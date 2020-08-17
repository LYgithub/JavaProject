package 设计模式.创造者模式.computer;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式.computer
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class MacBookBuilder extends Builder{
    private MacBook macBook = new MacBook();

    @Override
    void buildBoard(String board) {
        macBook.setmBoard(board);
    }

    @Override
    void buildDisplay(String display) {
        macBook.setmDisplay(display);
    }

    @Override
    void buildOs() {
        macBook.setOs();
    }

    @Override
    Computer build() {
        return macBook;
    }
}
