package com.alw.teching_system.mapper;

import com.alw.teching_system.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * user表的mapper接口，获取用户相关的信息
 */
@Mapper
@Repository
public interface UserMapper extends BaseMapper<Users> {
}
