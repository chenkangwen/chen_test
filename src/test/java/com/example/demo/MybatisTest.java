package com.example.demo;

import com.example.demo.dao.IOrderMapper;
import com.example.demo.entity.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.Reader;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/2 20:35
 **/
public class MybatisTest extends DemoApplicationTests {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;


    //这个SqlSessionFactoryBuilder类的存在很简单,取名也叫他构建器,Mybatis的官网是这样解释它的,
    //这个类可以被实例化(因为它有且仅有一个默认的无参构造),
    //使用它的目的就是用来创建多个SqlSessionFactory实例,
    //最好不要让他一直存在,进而保证所有用来解析xml的资源可以被释放
    @Test
    public void selectUserTest() {
        String resource = "mybatis-config.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSession = sqlSessionFactory.openSession();
            IOrderMapper iOrderMapper = sqlSession.getMapper(IOrderMapper.class);
            Order order = iOrderMapper.getOrderById("123456");
            //提交sqlSession
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }


    @Test
    public void testYou() {
        //扩展类加载器Main
        ClassLoader classLoader = MybatisTest.class.getClassLoader();
        //表示当前线程的类加载器——应用程序类加载器
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //启动类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
    }

}
