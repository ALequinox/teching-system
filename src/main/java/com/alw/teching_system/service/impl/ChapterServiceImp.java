package com.alw.teching_system.service.impl;

import com.alw.teching_system.entity.Chapter;
import com.alw.teching_system.mapper.ChapterMapper;
import com.alw.teching_system.service.ChapterService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ChapterServiceImp implements ChapterService {

    @Autowired
    ChapterMapper chapterMapper;

    /**
     * 查询当前课程下的所有章
     * 过滤已删除
     * @param cid
     * @return
     */
    @Override
    public List<Chapter> selectAllChapterByCid(int cid) {

        return chapterMapper.selectAllByCidChapterList(cid);
    }

    /**
     * 删除单章
     * @param chid 章id
     * @return
     */
    @Override
    public int deleteChapterByChid(int chid) {
        Chapter chapter = chapterMapper.selectById(chid);
        chapter.setIsDelete(false);
        return chapterMapper.updateById(chapter);
    }

    /**
     * 批量删除课程下的章
     * @param cid
     * @return
     */
    @Override
    public int deletAllChaptersBycid(int cid) {
        Chapter chapter=new Chapter();
        chapter.setIsDelete(false);
        System.out.println(chapter);
        UpdateWrapper<Chapter> wrapper=new UpdateWrapper<Chapter>();
        wrapper.eq("is_delete",1);
        int result= chapterMapper.update(chapter,wrapper);
        System.out.println(result);
        return 0;
    }

    /**
     * 为当前课程添加章
     * @param chapter
     * @return
     */
    @Override
    public int addChapter(Chapter chapter) {
        return chapterMapper.insertChapter(chapter);
    }
}
