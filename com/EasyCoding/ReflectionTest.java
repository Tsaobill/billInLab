package com.EasyCoding;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-06-15 21:23
 **/
public class ReflectionTest {

    // 任何小写class定义的类，都有一个魔法属性：class，来获取此类的大写 Class 类对象,有三种方法，
    // 下面的一种，类名静态加载.class属性，还有另外两种:类对象通过从Object继承的getClass()方法以及Class的静态方法forName(String className)

    private static Class<One> one = One.class;
    private static Class<Another> another = Another.class;

    public static void main(String[] args)  throws Exception{

        //获取应用类加载器
        ClassLoader cl = ReflectionTest.class.getClassLoader ();

        // 应用类加载器的父加载器是 PlatformClassLoader
        ClassLoader cl1 = cl.getParent ();
        // PlatformClassLoader的父加载器是 Bootstrap，c++实现，返回null
        ClassLoader cl2 =cl1.getParent ();
        System.out.println (cl+"\n" + cl1+"\n"+ cl2+"\n");


//====================================================================================


        One oneObject = one.getDeclaredConstructor ().newInstance ();
        oneObject.call ();

        Another anotherObject = another.getDeclaredConstructor ().newInstance ();
        anotherObject.speak ();

        Field[] fields = one.getDeclaredFields ();
        fields[0].getName ();

        Method method = one.getMethod ("getInner");
        method.invoke (oneObject);

        // 通过one这个大写的Class对象，获取私有成员属性对象Filed
        Field privateFieldInOne = one.getDeclaredField ("inner");

        // 修改访问权限
        privateFieldInOne.setAccessible (true);

        // 修改值
        privateFieldInOne.set(oneObject,"word changed.");

        System.out.println (oneObject.getInner ());
    }

}

class One {
    public  One(){

    }
    private String inner = "time flies";

    public void call() {
        System.out.println ("hello world.");
    }

    public String getInner() {
        return inner;
    }
}

class Another {
    public void speak() {
        System.out.println ("easy coding.");
    }
}
