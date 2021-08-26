package com.alw.teching_system.mapper;

import com.alw.teching_system.entity.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {

    public int insertChapter(Chapter chapter);

    List<Chapter> selectAllByCidChapterList(Integer cid);

}
