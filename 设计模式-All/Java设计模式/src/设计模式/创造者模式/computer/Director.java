package 设计模式.创造者模式.computer;

/**
 * @author LiYang
 *
 * 完成创建过程的顺序控制
 */
public class Director {
    Builder builder;
    protected Director(Builder builder){
        this.builder =builder;
    }

    protected Computer construct(String board, String disPlay){
        builder.buildBoard(board);
        builder.buildDisplay(disPlay);
        builder.buildOs();
        return builder.build();
    }
}
