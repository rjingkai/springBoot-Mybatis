package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public int addUser(User user){
        return UserMapper.insertSelective(user);
    }

    @Override
    public List<User> getAll(int pageNum,int PageSize){
        //将参数传给这个方法就可以实现物理分页了，非常简单。
//        PageHelper.startPage(pageNum, PageSize);
        return UserMapper.selectAllUser();
    }

    @Override
    public int count(){
        return UserMapper.count();
    }

}
