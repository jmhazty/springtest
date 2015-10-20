package com.walye.service;

import org.springframework.stereotype.Component;

import com.walye.interceptor.DoAopAnnotation;

@Component
public class AopService {
	@DoAopAnnotation(where = "in beijing")
	public String swimming(String name){
		return name + " is swimming ";
//		throw new RuntimeException("wife call");
	}

}
