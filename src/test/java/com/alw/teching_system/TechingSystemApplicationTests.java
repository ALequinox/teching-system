package com.alw.teching_system;

import com.alw.teching_system.entity.Course;
import com.alw.teching_system.mapper.CourseMapper;
import com.alw.teching_system.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;
import java.util.List;

@SpringBootTest
class TechingSystemApplicationTests {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    CourseService courseService;

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

    @Test
    void testCourseServiceImp(){
        Course course = new Course();
        course.setCid(0);
        course.setCName("123");
        course.setCDesc("123");
        course.setCLevel(1);
        course.setLastTime(new Date());
        course.setIsDelete(true);
        course.setUser(null);
        int i = courseService.addCourse(course, "zhangsan");
        System.out.println(i);
        System.out.println(course);
    }

    @Test
    void testSelectAllCourse(){
        List<Course> zhangsan = courseService.selectAllCourse("zhangsan");
        System.out.println(zhangsan);
    }

}
