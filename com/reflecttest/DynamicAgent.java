package com.reflecttest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-01 15:38
 **/
public class DynamicAgent {
    static class MyHandler implements InvocationHandler {
        private Object proxy;

        public MyHandler(Object proxy) {
            this.proxy = proxy;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println (">>>>>before invoking");
            Object res = method.invoke (this.proxy, args);
            System.out.println (">>>>>after invoking");
            return res;
        }
    }

    public static Object agent(Class interfaceClazz, Object proxy) {
        return Proxy.newProxyInstance (interfaceClazz.getClassLoader (), new Class[]{interfaceClazz}, new MyHandler (proxy));
    }

    public static void main(String[] args) {
//        Animal animal = (Animal) DynamicAgent.agent (Animal.class,new Dog ());
        Animal animal = (Animal) Proxy.newProxyInstance (Animal.class.getClassLoader (), new Class[]{Animal.class}, (a, b, c) -> b.invoke (new Dog (), c));
        animal.bark ();
        animal.watch ();
        animal.eat ("屎");
    }
}
