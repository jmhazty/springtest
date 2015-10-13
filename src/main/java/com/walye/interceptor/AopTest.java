package com.walye.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {
	@Pointcut("@annotation(DoAopAnnotation)")
	public void pointcut(){	
	}
	@Around("pointcut()")
	public Object doaop(ProceedingJoinPoint point) throws Throwable {
		// TODO Auto-generated method stub
		String name = point.getSignature().getName();
		System.out.println("do " + name + "before");
		Object result = point.proceed();
		System.out.println(result);
		System.out.println("do " + name + "after");
		return result;
	}

}
