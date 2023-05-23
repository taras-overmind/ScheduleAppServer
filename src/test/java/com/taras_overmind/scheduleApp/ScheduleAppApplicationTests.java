package com.taras_overmind.scheduleApp;

import com.taras_overmind.scheduleApp.model.entity.User;
import com.taras_overmind.scheduleApp.model.enums.UserRole;
import com.taras_overmind.scheduleApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScheduleAppApplicationTests {
	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		userService.registerNewAccount(new User("taras1", "1234567", UserRole.ADMIN, "ttp@gmail.com"));
	}

}
