package com.smart4j.chapter01.tmp;

/**
 * @program: chapter01
 * @description: 抽象的工人，定义一个算法骨架
 * @author: sxj
 * @create: 2019-11-28 16:21
 **/
public abstract class AbstractWorker {

    protected void getUp() {
        System.out.println("getUp");
    }

    protected abstract void haveBreakfast();

    protected abstract void byTransport();

    protected void work() {
        System.out.println("work");
    }

    public void conductOfLife() {
        getUp();
        haveBreakfast();
        byTransport();
        work();
    }


}
