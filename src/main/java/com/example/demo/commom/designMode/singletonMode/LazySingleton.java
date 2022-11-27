package com.example.demo.commom.designMode.singletonMode;

/**
 * 懒汉式单例模式
 *             优点：使用对象时，对象才创建，所以不会提前占用内存，内存占用小
 *             缺点：首次使用对象时，需要等待对象的创建，而且每次都需要判断对象是否为空，运行效率较低
 *             以时间换空间
 */
public class LazySingleton {

    private static volatile LazySingleton instance = null;    //保证 instance 在所有线程中同步

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        //getInstance 方法前加同步
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
