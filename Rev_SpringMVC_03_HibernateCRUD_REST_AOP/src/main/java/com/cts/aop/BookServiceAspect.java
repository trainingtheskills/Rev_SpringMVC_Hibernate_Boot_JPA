package com.cts.aop;

import java.util.Date;
import java.util.List;

import javax.persistence.JoinTable;
import javax.print.attribute.standard.DateTimeAtCreation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.cts.model.Book;

@Aspect
@Component
public class BookServiceAspect {
	
	
	//Aspect  -  Cross cutting Module Eg: BookServiceAspect
	//JointPoint -  join point always represents a method execution. Eg: BookServiceImpl methods
	//ADVICE - @Before /@After / @Around
	//Pointcut - execution(* com.cts.service.BookServiceImpl.listAllBooks(..)) 
	/*@Before("execution(* com.cts.service.BookServiceImpl.listAllBooks(..)) ")
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("Data going to fetched on "+ new Date()+ "Using method: "+joinPoint.getSignature());
	}
*/
	/*@After("execution(* com.cts.service.BookServiceImpl.listAllBooks(..)) ")
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("After method:" + joinPoint.getSignature().getName());

		System.out.println("Loaded all books @" + new Date());
	}
*/
@Around("execution(* com.cts.service.BookServiceImpl.listAllBooks(..)) ")
	public void aroundAdvice(JoinPoint joinPoint) {
		//System.out.println("Around :" + joinPoint.getSignature().getName());
		System.out.println("Before and After  all books @" + new Date());
	}
	
}
