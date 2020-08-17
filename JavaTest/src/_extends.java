/**
 * @author LiYang
 * @Project Name: JavaTest
 * @Package Name: PACKAGE_NAME
 * Created by MacBook Air on 2020/02/10.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class _extends {
    public static void main(String[] args) {
        Shape shape;
        //多态实现
        shape = new Line("red",12.5,10.5);
        shape.print();
        shape = new LinePro();
        shape.print();
        //#
    }
}

abstract class Shape {
    private String color;
    private double width;
    public Shape(){}
    Shape(String color, double width){this.color=color;this.width=width;}
    String getColor(){return color;}
    double getWidth(){return width;}
    void setColor(String color){this.color = color;}
    void setWidth(double width){this.width = width;}
    //抽象方法
    abstract void print();
}

class Line extends Shape {
    private double length;
    Line(){}
    Line(String color, double width, double length){
        super("sd",123.3);
        setColor(color);
        setWidth(width);
        this.length = length;
    }
    //子类中将抽象方法实现
    void print(){
        System.out.println("颜色为："+super.getColor()+"\n宽度为："+super.getWidth()+"\n----");
        System.out.println("线的颜色是:"+this.getColor()+"\n宽度为："+this.getWidth()+"\n长度为："+this.length);
    }
}

class LinePro extends Line{
    double pro;
    public void print(){
        super.print();
        System.out.println(pro);
    }
}