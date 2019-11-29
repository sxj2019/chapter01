package com.smart4j.chapter01.model;

import com.smart4j.chapter01.utils.ClassUtil;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 15:03
 **/
public class Customer {
    private long id;
    private String name;
    private String contact;
    private String telephone;
    private String email;
    private String remark;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return ClassUtil.commonToString(this.getClass(),this);
    }
}
