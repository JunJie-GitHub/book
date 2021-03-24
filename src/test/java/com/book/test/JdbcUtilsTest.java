package com.book.test;

import com.book.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testConnection(){
        for (int i=0;i<100;i++){
            System.out.println(JdbcUtils.getConnection());
        }
//        Connection con = JdbcUtils.getConnection();
//        System.out.println(con);
//        JdbcUtils.close(con);
    }
}
