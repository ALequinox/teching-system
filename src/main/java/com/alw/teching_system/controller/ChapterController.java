package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Chapter;
import com.alw.teching_system.entity.Message;
import com.alw.teching_system.service.ChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class ChapterController {

    @Autowired
    ChapterService chapterService;

    /**
     * 将要操作的课程id放入页面中
     * @param cid
     * @param request
     * @return
     */
    @GetMapping("/chapter/{cid}")
    public String chaptersPage(@PathVariable("cid")Integer cid,
                              HttpServletRequest request){
        log.info("提交的课程id为:{}",cid);
        request.setAttribute("cid",cid);
        return "course";
    }

    /**
     * 查询对应的课程的详细内容
     * @param cid
     * @return
     */
    @GetMapping("/chapter")
    @ResponseBody
    public List<Chapter> getChaptersDetail(@RequestParam("cid")String cid){
        log.info("查看的课程id={}",cid);
        return chapterService.selectAllChapterByCid(Integer.parseInt(cid));
    }

    /**
     * 添加新的章节
     * @param cid
     * @param chapterName
     * @return
     */
    @PostMapping("/chapter")
    @ResponseBody
    public Message addNewChapter(@RequestParam("cid")Integer cid,
                                 @RequestParam("chapterName")String chapterName){
        log.info("修改的课程id={},添加的章节名={}",cid,chapterName);
        Message message = new Message();
        Chapter chapter = new Chapter();
        chapter.setChid(0);
        chapter.setChName(chapterName);
        chapter.setCid(cid);
        chapter.setLastTime(new Date());
        chapter.setIsDelete(false);
        if(chapterService.addChapter(chapter)>0){
            message.setCode(0);
            message.setMessage("添加成功");
        }else{
            message.setCode(1);
            message.setMessage("添加失败");
        }
        return message;
    }


}


