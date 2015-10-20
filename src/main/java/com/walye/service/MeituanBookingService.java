package com.walye.service;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MeituanBookingService implements IBookingService {

	@Override
	public void bookRoom() {
		System.out.println("book room by meituan!");
	}

}
