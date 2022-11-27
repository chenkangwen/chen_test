package com.example.demo.commom.collection;

import com.alibaba.fastjson.JSON;
import com.example.demo.entity.Father;
import com.example.demo.entity.UserDTO;

import java.util.*;

public class ListTest {

    public static void main(String[] args) {


    }

    public static void test1(){
        Vector<String> vector = new Vector<>();
        vector.add("朱雀");
        vector.add("白虎");

        System.out.println();


        Stack<String> stack = new Stack<>();
        //stack.add("西方");
        //stack.add("北方");
        stack.push("凤");
        stack.push("龙");
        stack.push("龟");
        String peek = stack.peek();
        System.out.println(peek);


        Deque<String> deque = new ArrayDeque<>();
        deque.push("凤");
        deque.push("龙");
        deque.push("龟");
    }


    public static void test() {
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO("西施", 18));
        list.add(new UserDTO("王昭君", 16));
        list.add(new UserDTO("杨昭君", 20));
        list.add(new UserDTO("貂蝉", 24));
        list.add(new UserDTO("猪八戒", 5));
        list.add(new UserDTO("猪八戒1", 5));
        Collections.sort(list, new Comparator<UserDTO>() {
            @Override
            public int compare(UserDTO o1, UserDTO o2) {
                if (o2.getAge()>o1.getAge()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.err.println(JSON.toJSONString(list));
    }

    public static void test_1() {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("haha");
        linkedList.add("hehe");
        for (String str : linkedList) {

        }
        String first = linkedList.getFirst();
        System.out.println(first);
    }

}
