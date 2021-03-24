package com.book.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    static {
        try {
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            //创建数据库连接池
            dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 获取数据库连接池中的Connection
     * @return 如果返回null, 说明获取连接失败<br/>有值就是获取连接成功
     */
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = dataSource.getConnection();
            threadLocal.set(con);
            con.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    /**
     * 提交事务, 并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = threadLocal.get();
        if (connection != null){    //不等于null, 之前连接过数据库
            try {
                connection.commit();    //提交事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close(); //关闭连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove操作, 否则会出错(Tomcat服务器底层使用线程池技术)
        threadLocal.remove();
    }

    /**
     * 回滚事务, 并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = threadLocal.get();
        if (connection != null){    //不等于null, 之前连接过数据库
            try {
                connection.rollback();    //回滚事务
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    connection.close(); //关闭连接
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        //一定要执行remove操作, 否则会出错(Tomcat服务器底层使用线程池技术)
        threadLocal.remove();
    }

    public static void close(Connection con){
        if (con!=null){
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
