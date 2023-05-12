package com.weiz.helloworld;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloTest {
    @Test
    public void hello(){
        System.out.println("Hello Spring Boot Test");
    }
}

