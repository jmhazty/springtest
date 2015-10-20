package com.walye.ioc;

public class MeituanApp {
	public static void main(String[] args) {
		boosNiuGetSleepRoom();
	}

	static void boosNiuGetSleepRoom() {
		BossNiu boos = new BossNiu();
		boos.getSleepRoom();
	}
}
