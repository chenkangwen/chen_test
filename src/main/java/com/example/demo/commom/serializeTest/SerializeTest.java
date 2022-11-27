package com.example.demo.commom.serializeTest;

import com.example.demo.commom.model.Company;
import com.example.demo.commom.model.User;

import java.io.*;
import java.lang.reflect.Constructor;

public class SerializeTest {


    public static void main(String[] args)throws Exception {
      /*  ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\file\\test.txt"));
        oos.writeObject(new User("chenkangwen","28","男","中国"));

        ObjectInputStream ois= new ObjectInputStream(new FileInputStream("D:\\file\\test.txt"));
        User user = (User) ois.readObject();
        System.out.println(user.toString());*/

       //test();
       //test1();

        Class<?> css = Class.forName("com.example.demo.commom.model.User");
        Constructor<?>[] constructors = css.getConstructors();
        Constructor<?> declaredConstructor = css.getDeclaredConstructor();
        User user =(User) declaredConstructor.newInstance();


    }


    public static void test() throws CloneNotSupportedException{
        User userOne, userTwo, userThree;
        userOne = new User("username", "password");
        userTwo = userOne;
        userThree = (User) userOne.clone();

        System.out.println(userTwo==userOne);            //true
        System.out.println(userTwo.equals(userOne));    //true

        System.out.println(userThree==userOne);            //false
        System.out.println(userThree.equals(userOne));    //true
    }

    public static void test1() throws CloneNotSupportedException{
        Company companyOne, companyTwo, companyThree;
        companyOne = new Company(new User("username", "password"), "上海市");
        companyTwo = companyOne;
        companyThree = (Company) companyOne.clone();

        System.out.println(companyTwo==companyOne);                //true
        System.out.println(companyTwo.equals(companyOne));        //true

        System.out.println(companyThree==companyOne);            //false
        System.out.println(companyThree.equals(companyOne));    //true

        System.out.println(companyThree.getUser()==companyOne.getUser());            //true ? 这里为什么不是false呢
        System.out.println(companyThree.getUser().equals(companyOne.getUser()));    //true

    }


}
