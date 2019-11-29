package com.smart4j.chapter01.service;

import com.smart4j.chapter01.dao.common.CommonDao;
import com.smart4j.chapter01.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 15:12
 **/
public class CustomerService {

    private CommonDao<Customer> commonDao;

    public CustomerService(CommonDao<Customer> commonDao) {
        this.commonDao = commonDao;
    }

    //获取列表
    public List<Customer> getCustomerList(){
//        String sql = "select * from customer";
        List<Customer> customers = commonDao.getEntityList();
        return customers;
    }

    //获取用户
    public Customer getCustomer(long id){
//        String sql = "select * from customer where id = ?";
        List<Customer> customers = commonDao.getEntityList(id);
        return customers.get(0);
    }

    //创建客户
    public boolean createCustomer(Map<String,Object> fieldMap){
        return commonDao.addEntity(fieldMap);
    }

    //更新客户
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
        return commonDao.updateEntity(id,fieldMap);
    }
    //删除客户
    public boolean deleteCustomer(long id){
        return commonDao.deleteEntity(id);
    }
}
