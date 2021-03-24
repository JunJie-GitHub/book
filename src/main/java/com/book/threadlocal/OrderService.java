package com.book.threadlocal;

public class OrderService {

    public void creatOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("当前线程名 "+name+"保存数据是 "+ThreadLocalTest.threadLocal.get());
    }
}
