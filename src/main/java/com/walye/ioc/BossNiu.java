package com.walye.ioc;

import javax.annotation.Resource;

import com.walye.service.IBookingService;

public class BossNiu {
	@Resource
	private IBookingService bookingService;

	public void getSleepRoom() {
		bookingService.bookRoom();
	}
}
