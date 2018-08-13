package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserService {
    int addUser(User user);

    int count();

    List<User> getAll(int pageNum,int pageSize);
}
