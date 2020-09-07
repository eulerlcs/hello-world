package com.github.eulerlcs.hello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.eulerlcs.hello.domain.User;

@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	void testSelectUser() {
		User user = userService.selectUser(1);
		assertEquals(1, user.getId());
		assertEquals("zhangsan", user.getName());
		assertEquals("department 1", user.getDepartment());
	}
}
