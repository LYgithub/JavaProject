package 设计模式.原型模式;

import java.io.*;

/**
 * @author LiYang
 * @Project Name: Java设计模式
 * @Package Name: 设计模式.原型模式
 * Created by MacBook Air on 2020/07/17.
 * Copyright © 2020 LiYang. All rights reserved.
 */
public class Solution {
    public static void main(String[] args) {
        Product product = new Product();
        Product clone = null;
        try {
            clone = ((Product) product.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        clone.setId(1);
        System.out.println(product.toString());
        System.out.println(clone.toString());
    }

}

class Product implements Cloneable,Serializable{
    int id = 2;
    Inner inner ;
    static final long serialVersionUID = 42L;
    public Product() {
        this.id = 2;
        this.inner = new Inner();
    }

    public Inner getInner() {
        return inner;
    }

    public void setInner(Inner inner) {
        this.inner = inner;
    }

    @Override
    public String toString() {
        return this.hashCode() + "] Product{" +
                "id=" + id +
                ", inner=" + inner +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Creates and returns a copy of this object.  The precise meaning
     * of "copy" may depend on the class of the object. The general
     * intent is that, for any object {@code x}, the expression:
     * <blockquote>
     * <pre>
     * x.clone() != x</pre></blockquote>
     * will be true, and that the expression:
     * <blockquote>
     * <pre>
     * x.clone().getClass() == x.getClass()</pre></blockquote>
     * will be {@code true}, but these are not absolute requirements.
     * While it is typically the case that:
     * <blockquote>
     * <pre>
     * x.clone().equals(x)</pre></blockquote>
     * will be {@code true}, this is not an absolute requirement.
     * <p>
     * By convention, the returned object should be obtained by calling
     * {@code super.clone}.  If a class and all of its superclasses (except
     * {@code Object}) obey this convention, it will be the case that
     * {@code x.clone().getClass() == x.getClass()}.
     * <p>
     * By convention, the object returned by this method should be independent
     * of this object (which is being cloned).  To achieve this independence,
     * it may be necessary to modify one or more fields of the object returned
     * by {@code super.clone} before returning it.
     *
     * 通常，这意味着*复制包含要克隆对象的内部“深度结构”的任何可变对象
     * *并将对这些对象的引用替换为对副本的引用。如果一个类仅包含原始字段或对不可变对象的引用，
     * 则通常情况下，无需修改{@code super.clone}返回的对象中的任何字段。
     *
     * Typically, this means
     * copying any mutable objects that comprise the internal "deep structure"
     * of the object being cloned and replacing the references to these
     * objects with references to the copies.  If a class contains only
     * primitive fields or references to immutable objects, then it is usually
     * the case that no fields in the object returned by {@code super.clone}
     * need to be modified.
     * <p>
     * The method {@code clone} for class {@code Object} performs a
     * specific cloning operation. First, if the class of this object does
     * not implement the interface {@code Cloneable}, then a
     * {@code CloneNotSupportedException} is thrown. Note that all arrays
     * are considered to implement the interface {@code Cloneable} and that
     * the return type of the {@code clone} method of an array type {@code T[]}
     * is {@code T[]} where T is any reference or primitive type.
     * Otherwise, this method creates a new instance of the class of this
     * object and initializes all its fields with exactly the contents of
     * the corresponding fields of this object, as if by assignment; the
     * contents of the fields are not themselves cloned. Thus, this method
     * performs a "shallow copy" of this object, not a "deep copy" operation.
     * <p>
     * The class {@code Object} does not itself implement the interface
     * {@code Cloneable}, so calling the {@code clone} method on an object
     * whose class is {@code Object} will result in throwing an
     * exception at run time.
     *
     * @return a clone of this instance.
     * @throws CloneNotSupportedException if the object's class does not
     *                                    support the {@code Cloneable} interface. Subclasses
     *                                    that override the {@code clone} method can also
     *                                    throw this exception to indicate that an instance cannot
     *                                    be cloned.
     * @see Cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 修改clone 方法，实现深复制
        // return super.clone();
//        Product clone = (Product) super.clone();
//        System.out.println(clone.toString());
//        Inner inner = ((Inner) clone.getInner().clone());
//        clone.setInner(inner);
//        return clone;

        //序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            outputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try(ObjectInputStream inputStream = new ObjectInputStream(byteArrayInputStream)){
            Product product = ((Product) inputStream.readObject());
            return product;
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}

class Inner implements Cloneable, Serializable{
    int id = 3;
    static final long serialVersionUID = 42L;
    @Override
    public String toString() {
        return this.hashCode() +  "] Inner{" +
                "id=" + id +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}