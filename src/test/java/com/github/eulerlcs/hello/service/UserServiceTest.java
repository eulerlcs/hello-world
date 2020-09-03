package com.github.eulerlcs.hello.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.eulerlcs.hello.domain.User;
import com.github.eulerlcs.hello.mapper.UserMapper;

@SpringBootTest
class UserServiceTest {
	@Autowired
	private UserService userService;

	@Test
	void testSelectUser() {
		ss1();
		User user = userService.selectUser(1);
		assertEquals(1, user.getId());
		assertEquals("zhangsan", user.getName());
		assertEquals("d2", user.getDepartment());
	}

	private void ss1() {
		User mockUser = new User();
		mockUser.setId(1);
		mockUser.setName("zhangsan");
		mockUser.setDepartment("d2");

		UserMapper userMapper = mock(UserMapper.class);

		when(userMapper.selectById(1)).thenReturn(mockUser);

		// the following prints "first"
		System.out.println(userMapper.selectById(1));
	}
}
