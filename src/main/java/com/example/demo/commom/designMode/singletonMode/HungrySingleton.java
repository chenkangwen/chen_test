package com.example.demo.commom.designMode.singletonMode;

/**
     * 饿汉式单例模式
 *             优点：对象提前创建好了，使用的时候无需等待，效率高
 *             缺点：对象提前创建，所以会占据一定的内存，内存占用大
 *             以空间换时间
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
