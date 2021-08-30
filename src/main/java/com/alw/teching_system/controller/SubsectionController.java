package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Message;
import com.alw.teching_system.entity.Subsection;
import com.alw.teching_system.service.SubsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SubsectionController {

    @Autowired
    SubsectionService subsectionService;

    @PostMapping("/subsection")
    public Message addSubsection(@RequestParam("chid") Integer chid,
                                 @RequestParam("subsectionName") String subsectionName){
        Message message = new Message();
        Subsection subsection = new Subsection();
        subsection.setChid(chid);
        subsection.setSsName(subsectionName);
        subsection.setIsDelete(false);
        subsection.setLastTime(new Date());
        subsection.setSsid(0);

        if (subsectionService.addSubsection(subsection)>0) {
            message.setMessage("添加小节成功");
            message.setCode(0);
        }else{
            message.setCode(1);
            message.setMessage("添加失败");
        }

        return message;
    }
}
