package com.smart4j.chapter01.model;

import com.smart4j.chapter01.utils.ClassUtil;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 19:36
 **/
public class User {
    private long id;
    private String name;
    private String telephone;
    private String address;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return ClassUtil.commonToString(this.getClass(),this);
    }
}
