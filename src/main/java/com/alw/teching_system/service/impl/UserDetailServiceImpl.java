package com.alw.teching_system.service.impl;

import com.alw.teching_system.entity.Users;
import com.alw.teching_system.mapper.UserMapper;
import com.alw.teching_system.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 自定义处理用户登录的Service，自定义用户判断逻辑
 */
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService, UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",s);
        Users user = userMapper.selectOne(queryWrapper);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println(user);
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User(user.getUsername(),user.getPassword(),auths);
    }


    @Override
    public Users changePassword(Users users) {
        return null;
    }
}
