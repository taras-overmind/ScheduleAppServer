package com.taras_overmind.scheduleApp;

import com.taras_overmind.scheduleApp.model.entity.User;
import com.taras_overmind.scheduleApp.model.enums.UserRole;
import com.taras_overmind.scheduleApp.model.enums.WeekDay;
import com.taras_overmind.scheduleApp.repository.CustomQueries;
import com.taras_overmind.scheduleApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ScheduleAppApplicationTests {
	@Autowired
	private UserService userService;

	@Autowired
	private CustomQueries customQueries;

	@Test
	void contextLoads() {
		userService.registerNewAccount(new User("taras1", "1234567", UserRole.ADMIN, "ttp@gmail.com"));
	}

	@Test
	void test2(){
		System.out.println(customQueries.getAppointmentsByGroupAndWeekDay(1L, WeekDay.MONDAY.ordinal()));
		System.out.println(customQueries.getAppointmentsByLecturerAndWeekDay(1L, WeekDay.MONDAY.ordinal()));
	}
}
