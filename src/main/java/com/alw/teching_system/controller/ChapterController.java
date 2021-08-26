package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Chapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class ChapterController {


    @GetMapping("/chapter/{cid}")
    public String chaptersPage(@PathVariable("cid")Integer cid,
                              HttpServletRequest request){
        log.info("提交的课程id为:{}",cid);
        request.setAttribute("cid",cid);
        return "course";
    }


    @GetMapping("/chapter")
    public List<Chapter> getChaptersDetail(@RequestParam("cid")Integer cid){
        return null;
    }


}


