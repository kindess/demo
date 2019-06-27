package com.yunze.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDataSource() throws Exception {
        // 获取配置的数据源
        // 查看配置数据源信息
        System.out.println("当前使用的数据源: "+dataSource.getClass().getName());

        System.out.println("======================");
        System.out.println(dataSource.getConnection());
    }
}
