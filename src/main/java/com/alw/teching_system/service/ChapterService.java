package com.alw.teching_system.service;

import com.alw.teching_system.entity.Chapter;

import java.util.List;

public interface ChapterService {
    /**
     * 查询课程下所有章
     * @param cid
     * @return
     */
    public List<Chapter> selectAllChapterByCid(int cid);


    /**
     * 删除单个章节
     * @param chid 章id
     * @return
     */
    public int deleteChapterByChid(int chid);

    /**
     * 删除指定课程下的所有章
     * @param cid
     * @return
     */
    public int deletAllChaptersBycid(int cid);


    /**
     * 添加章
     * @param chapter
     * @return
     */
    public int addChapter(Chapter chapter);
}
