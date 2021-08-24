package com.alw.teching_system;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class TechingSystemApplicationTests {

    @Autowired
    UserDetailsService userDetailsService;

    @Test
    void contextLoads() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123456");
        System.out.println(encode);
    }

    @Test
    void testUserDetailServiceImpl(){
        UserDetails zhangsan = userDetailsService.loadUserByUsername("zhangsan");
        System.out.println(zhangsan.getUsername());

    }

}
