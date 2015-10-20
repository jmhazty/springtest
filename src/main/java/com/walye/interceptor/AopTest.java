package com.walye.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopTest {
//	@Pointcut("@annotation(an)")
//	public void pointcut(DoAopAnnotation an){	
//	}
//	@Around(value = "pointcut(an)")
//	public Object doaop(ProceedingJoinPoint point, DoAopAnnotation an) throws Throwable {
//		// TODO Auto-generated method stub
//		String name = point.getSignature().getName();
//		System.out.println("do " + name + "before" + an.name());
//		Object result = point.proceed();
//		System.out.println(result);
//		System.out.println("do " + name + "after");
//		return result;
//	}

}
