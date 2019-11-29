package com.smart4j.chapter01.tmp;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 16:30
 **/
public class BWorker extends AbstractWorker {
    @Override
    protected void haveBreakfast() {
        System.out.println("B have breakfast");
    }

    @Override
    protected void byTransport() {
        System.out.println("byTransport");
    }
}
