package com.smart4j.chapter01.tmp;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 16:28
 **/
public class Client {

    public static void main(String[] args) {
        AbstractWorker worker = new AWorker();
        worker.conductOfLife();
        System.out.println("------------------");
        AbstractWorker worker1 = new BWorker();
        worker1.conductOfLife();

    }
}
