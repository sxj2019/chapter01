package com.smart4j.chapter01.tmp;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 16:28
 **/
public class AWorker extends AbstractWorker {
    @Override
    protected void haveBreakfast() {
        System.out.println("A eat breakfast");
    }

    @Override
    protected void byTransport() {
        System.out.println("A byTransport");
    }
}
