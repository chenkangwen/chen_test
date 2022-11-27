package com.example.demo.service.impl;

import com.example.demo.commom.model.User;
import com.example.demo.dao.IOrderMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Override
    @Transactional
    public int insertUser(User user) {

        return 0;
    }

    @Override
    public int deleteUser(User user) {
        return 0;
    }
}
