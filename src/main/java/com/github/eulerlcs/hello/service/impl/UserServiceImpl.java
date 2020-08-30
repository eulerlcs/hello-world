package com.github.eulerlcs.hello.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.eulerlcs.hello.domain.User;
import com.github.eulerlcs.hello.mapper.UserMapper;
import com.github.eulerlcs.hello.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public User selectUser(Integer id) {
		return userMapper.selectById(id);
	}
}
