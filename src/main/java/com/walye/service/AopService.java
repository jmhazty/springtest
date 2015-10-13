package com.walye.service;

import org.springframework.stereotype.Component;

import com.walye.interceptor.DoAopAnnotation;

@Component
public class AopService {
	@DoAopAnnotation(name = "haha")
	public String doAop(){
		System.out.println("i'm doing");
		return "i'm aop service";
	}

}
