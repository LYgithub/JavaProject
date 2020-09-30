package 设计模式.创造者模式.computer;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.创造者模式.computer
 * Created by MacBook Air on 2020/07/12.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class HonerComputerBuilder extends Builder{
    HonorComputer computer = new HonorComputer();
    @Override
    void buildBoard(String board) {
        computer.setmBoard(board);
    }

    @Override
    void buildDisplay(String display) {
        computer.setmDisplay(display);
    }

    @Override
    void buildOs() {
        computer.setOs();
    }

    @Override
    Computer build() {
        return computer;
    }
}
