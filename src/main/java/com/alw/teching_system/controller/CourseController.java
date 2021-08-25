package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Course;
import com.alw.teching_system.entity.CourseLevel;
import com.alw.teching_system.entity.Message;
import com.alw.teching_system.service.CourseLevelService;
import com.alw.teching_system.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    CourseLevelService courseLevelService;

    @GetMapping("/getCourseLevel")
    @ResponseBody
    public List<CourseLevel> getCourseLevel(){
        return courseLevelService.getAllCourseLevel();
    }

    @PostMapping("/course")
    public String addCourse(@RequestParam Map map,
                            HttpSession session){
        //获取当前用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        //将表单中数据保存到实体类中
        String courseName = (String) map.get("course_name");
        String courseDesc = (String) map.get("course_desc");
        String courseLevel = (String) map.get("course_level");
        log.info("课程名={},课程描述={},课程等级={}",courseName,courseDesc,courseLevel);
        Course course = new Course();
        course.setCid(0);
        course.setCName(courseName);
        course.setCDesc(courseDesc);
        course.setCLevel(Integer.parseInt(courseLevel));
        course.setIsDelete(false);
        course.setLastTime(new Date());
        course.setUser(null);
        //添加课程
        int i = courseService.addCourse(course,user.getUsername());
        log.info("添加结果={}",i);
        Message message = new Message();
        if(i>0){
            message.setCode(0);
            message.setMessage("添加成功");
        }else{
            message.setCode(1);
            message.setMessage("添加失败");
        }
        session.setAttribute("message",message);
        return "redirect:/";
    }

    @GetMapping("/course")
    @ResponseBody
    public List<Course> getAllCourse(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        return courseService.selectAllCourse(user.getUsername());
    }
}
