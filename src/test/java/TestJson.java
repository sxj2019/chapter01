import com.smart4j.chapter01.model.Customer;
import com.smart4j.chapter01.utils.JsonUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 21:28
 **/
public class TestJson {

    @Test
    public void testObjToJson() {
        Customer cust = new Customer();
        cust.setId(11);
        cust.setName("Lucy");
        cust.setTelephone("186182729");

        Customer cust1 = new Customer();
        cust1.setId(22);
        cust1.setName("11Lucy");
        cust1.setTelephone("186182729");

        List<Customer> lst = new ArrayList<>();
        lst.add(cust);
        lst.add(cust1);
        String str = JsonUtil.objToJson(lst);
        System.out.println(str);
    }
}
