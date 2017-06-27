package com.how2java.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.how2java.pojo.Category;
import com.how2java.service.ProductService;
import com.how2java.pojo.Product;

public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "renameContext.xml" });

        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();
    }
}