package com.github.eulerlcs.hello.service;

import com.github.eulerlcs.hello.domain.User;

public interface UserService {
	User selectUser(Integer id);
}