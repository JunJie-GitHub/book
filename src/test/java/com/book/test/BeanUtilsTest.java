package com.book.test;

import com.book.pojo.User;
import com.book.web.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BeanUtilsTest {
    @Test
    public void test(){
        User user = new User();
        Map<String, Object> userMap = new HashMap<>();
//        userMap.put("id", 3);
        userMap.put("password", "1234fsdf");
        userMap.put("email", "a43435432@163.com");
        userMap.put("username", "jerry");
        Set<Map.Entry<String, Object>> entries = userMap.entrySet();
        for(Object obj: entries){
            System.out.println(obj);
        }
        try {
            System.out.println("导入前: "+user);
//            把所有请求参数都注入到对象中
            BeanUtils.populate(user, userMap);
            System.out.println("导入后: "+user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
