import com.smart4j.chapter01.dao.common.CommonDao;
import com.smart4j.chapter01.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: chapter01
 * @description:
 * @author: sxj
 * @create: 2019-11-28 19:35
 **/
public class TestUser {
    private static CommonDao<User> userDao;
    @Before
    public void init() {
        userDao = new CommonDao<>(  "user",User.class);
    }

    @Test
    public void testAdd() {
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put("name","A");
        boolean isAdd = userDao.addEntity(fieldMap);
        System.out.println("isAdd: "+isAdd);
    }

    @Test
    public void testUpdate() {
        Map<String,Object> fieldMap = new HashMap<>();
        fieldMap.put("name","B");
        boolean isUpdate = userDao.updateEntity(1,fieldMap);
        System.out.println("isUpdate: "+isUpdate);
    }

    @Test
    public void testDel() {
        boolean isDel = userDao.deleteEntity(2);
        System.out.println("isUpdate: "+isDel);
    }

    @Test
    public void testList() {
        List<User> list = userDao.getEntityList();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetEntityById() {
        long id = 1;
        List<User> entityList = userDao.getEntityList(1);
        User user = entityList.get(0);
        System.out.println(user);
    }

}
