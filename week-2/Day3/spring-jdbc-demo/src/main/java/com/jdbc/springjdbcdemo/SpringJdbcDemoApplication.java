package com.jdbc.springjdbcdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringJdbcDemoApplication.class, args);

        //		ApplicationContext ctx = SpringApplication.run(SpringDataJdbcApplication.class, args);
//		DbService service = ctx.getBean(DbService.class);
//		service.saveCar();
    }

}
