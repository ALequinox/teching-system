package com.alw.teching_system.service;

import com.alw.teching_system.entity.Users;

/**
 * 有关用户操作的业务逻辑
 */
public interface UserService {

    /**
     * 修改密码
     */
    public Users changePassword(Users users);

}
