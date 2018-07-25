package com.ravi.example;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class ApplicationAspect {
	
	static Log log;
	
	@Before("@annotation(com.ravi.example.Loggable)")
	public void loggableAdvice(JoinPoint jp){
		log = LogFactory.getLog(jp.getTarget().getClass());
		log.info("@Before Executing loggableAdvice!! " + jp.getSignature());
		/*System.out.println("@Before Executing loggableAdvice!! " + jp.getSignature());*/
	}
	
	@Before("execution(* com.ravi.example.*.print*())")
	public void getAllAdvice(){
		System.out.println("@Before Service method print*() called");
	}
	
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
	    long start = System.currentTimeMillis();
	    Object proceed = pjp.proceed();
	    long executionTime = System.currentTimeMillis() - start;
	    System.out.println(pjp.getSignature() + " executed in " + executionTime + "ms");
	    System.out.println("Agruments Passed=" + Arrays.toString(pjp.getArgs()));
	    System.out.println("Method returned object: "+ proceed);
	    return proceed;
	}
}
