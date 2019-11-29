import com.smart4j.chapter01.dao.common.CommonDao;
import com.smart4j.chapter01.dao.common.ListDao;
import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.service.CustomerService;
import com.smart4j.chapter01.utils.ClassUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 15:50
 **/
public class TestJDBC {
//    private static Connection conn;
    private static CustomerService customerService;
    @Before
    public void init() {
//        conn = DbHelper.getConnection();
//        CustomerDao customerDao = new CustomerDao();
        CommonDao<Customer> customerDao = new CommonDao<>("customer",Customer.class);
        customerService=new CustomerService(customerDao);
    }
    @Test
    public void testGetList() {
        List<Customer> customerList = customerService.getCustomerList();
        customerList.forEach(System.out::println);
    }

    @Test
    public void testCommonToString() {
        Customer cust = new Customer();
        cust.setId(1011);
        cust.setName("Lisi");
        String str = ClassUtil.commonToString(Customer.class, cust);
        System.out.println(str);
    }

    @Test
    public void testGetById() {
        long id = 6;
        Customer customer = customerService.getCustomer(id);
        System.out.println(customer);
    }

    @Test
    public void testAddCustomer() {
        Map<String,Object> fieldMap= new HashMap<>();
        fieldMap.put("name","A11");
        fieldMap.put("contact","A22");
        boolean ret = customerService.createCustomer(fieldMap);
        System.out.println("Ret: "+ret);
    }

    @Test
    public void testUpdateCustomer() {
        Map<String,Object> fieldMap= new HashMap<>();
        fieldMap.put("name","Lucy01");
        fieldMap.put("telephone","1861928");
        boolean isUpdate = customerService.updateCustomer(12,fieldMap);
        System.out.println("isUpdate: "+isUpdate);
    }

    @Test
    public void testDeleteCustomer() {
        boolean isDel = customerService.deleteCustomer(19);
        System.out.println("isDel: "+isDel);
    }

    @Test
    public void testListDao() {
        ListDao<Customer> listDao = new ListDao<>();
        String sql = "select * from customer";
        List<Customer> lst = (List<Customer>) listDao.execute(Customer.class,sql);
        lst.forEach(System.out::println);
    }
}
