package com.walye.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Swimming {
	@Pointcut(value = "execution(* com.walye.service.AopService.*(..)) ")
	public void pointcut() {
	}

	@Before(value = "pointcut()")
	public void warmUp() {
		System.out.println("warming up");
	}

	@After(value = "pointcut()")
	public void changeClothes() {
		System.out.println("change clothes");
	}

	@AfterReturning(value = "pointcut()")
	public void takeShower() {
		System.out.println("take a shower");
	}

	@Around(value = "pointcut() && @annotation(an)")
	public void arround(ProceedingJoinPoint joinpoint, DoAopAnnotation an) throws Throwable {
		System.out.println("befor");
		try {
			Object result = joinpoint.proceed();
			System.out.println(result + an.where());
		} catch (Exception e) {
			throw e;
			// TODO: handle exception
		}
		System.out.println("after");
	}

	@AfterThrowing(value = "pointcut()", throwing = "ex")
	public void backToHome(Exception ex) {
		System.out.println("back to home,because of " + ex.getMessage());
	}

}
