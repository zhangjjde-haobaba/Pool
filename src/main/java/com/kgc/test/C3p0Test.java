package com.kgc.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.lang.reflect.Field;
import java.sql.Connection;

/**
 * Created by jiang on 9/8/23 3:21 PM
 */
public class C3p0Test {
    public static void main(String[] args) throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/flight");
        //确保连接池中只有一个连接对象
        dataSource.setInitialPoolSize(1);
        //这个一定要设置 因为访问的数据量大会自动创建
        dataSource.setMaxPoolSize(1);

        //从数据库池中获取到连接
        Connection connection = dataSource.getConnection();
        Object inner = getInner(connection);
        connection.close(); //用完不关会导致其他资源获取不到
        Connection connection1 = dataSource.getConnection();
        Object inner1 = getInner(connection1);
        System.out.println(connection == connection1); //返回false 是因为返回的是两个代理对象
        System.out.println(inner == inner1); //返回true 返回的是同一个对象
//        System.out.println(connection.getClass().getName());
//        com.mchange.v2.c3p0.impl.NewProxyConnection 获取到的是一个代理对象 但是代理对象中肯定包含真正的对象
//        Object inner = getInner(connection);
//        System.out.println(inner.getClass().getName());
        //com.mysql.cj.jdbc.ConnectionImpl这才是真正的数据库连接对象
    }

    public static Object getInner(Object connection) throws Exception {
        Object result = null;
        Field field = null;
        //先获取到属性
        field = connection.getClass().getDeclaredField("inner");
        //暴力反射 在外部强行获取到内部属性
        field.setAccessible(true);
        //调用get方法将对象传入 获取到属性在对象中的值
        result = field.get(connection);
        return result;
    }
}
