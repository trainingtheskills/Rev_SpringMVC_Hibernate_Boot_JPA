package com.cts.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.cts.model.Book;

@Aspect
public class LogAspect {
	//1. To apply Logginadvice for all getName methods belongs to any class
			// @Before("execution(public String getName())")
	//2.To apply Logginadvice for getName of only circle class belongs to any class
			//@Before("execution(public String com.aop.Circle.getName())")
	//3. To apply Loggin Advice to all getter ( getName() as well getCircle too
			//@Before("execution(public * get*())")  //It is point cut for LoggingAdvice
	
	@Before("execution(public String getTitle()")
	public void LoggingAdvice()
	{System.out.println("Advice  run");
		
	}
	/*	
	//4. Apply myAdvice for all getter
	@Before("forAllGetter()")  //It is point cut for myAdvice
	public void myAdvice()
	{System.out.println("My second Advice");}
	
	//5. How to name the pointcut insead of "execution(public * get*())"
	 @Pointcut("execution(public * get*())")
	 public void forAllGetter() {}; //it will behave like placeholder
	 //Now you can use @Before as : @Before("allGetters()") refer point 4
	
	// 6. How to apply pointcut for all methods of circle class no matter how many
	// arguments in method.
	/*@Pointcut("execution(* * com.aop.Circle.*(..))")
	public void allCircleMethods() {
	}

	@Before("allCircleMethods()")
	public void myCircleAdvice() {
		System.out.println("My Circle Advice");
	}*/
	 
	 
	 //7. Another way to specify pointcut for all methods of Trainagle class no matter how many arguments in method.
	 @Pointcut("within(com.aop.Triangle)")	
		public void allTriangleMethods() {}
	 @Before("allTriangleMethods()")
	 public void traingleAdvice()
	 {
		 System.out.println("I am only for traingle");
	 }
	
	
	/*-----------NOT YET RUN---------------JoinPoint----------------------
	 @Pointcut("within(com.aop.Triangle)")	
		public void allTriangleSetMethods() {}
	 
	 @Before("allTriangleSetMethods()")
	 public void TestAdvice(JoinPoint jp) {		 
	 };
	 
	 @Before("args(name)")
	 public void stringArguments(String name)
	 {		 System.out.println("A method that takes String arguments and the value is "+ name);     } */
	 
//---------------@After irrespective of successful or not ------
	 /*@After("args(name)")
	 //public void forStringArgumentsMethods(String name) {
		 System.out.println(" Name parameter passed");
	 }*/
// ---------------@After successfull returing from methods ------
	 /*@AfterReturning("args(name)")
	 public void forSuccesfulStringArgumentsMethods(String name) {
		 System.out.println(" Successfully set the parameter");
	 }*/
// Handle return value
	/* @AfterThrowing (pointcut="args(name)", throwing = "ex")
	 	public void exceptionAdviceString(String name, RuntimeException ex)
	 	{
		 System.out.println("An Exception has been thrown");
	 	}*/
	 
/* AroungAdvice
	 @Around("forAllGetter()") 
	 public Object myAroundMethod(ProceedingJoinPoint pjp) 
	 {Object returnObj=null;
		 try {
			 System.out.print("Getter is going to execute");
			returnObj=pjp.proceed();
			System.out.print("Getter executed");
		} catch (Throwable e) {
			System.out.print("Exception thrown");
		} //COnditionally proceed the execute}
		return returnObj;
	 }
	 */
//Same above operation using custom nnotation
	 //Create an annotation in terms of interaces: RC-> new -> Annotation
	/*  @Around("@annotation(com.aop.Loggable)") 
	 public Object myAroundMethod(ProceedingJoinPoint pjp) 
	 {Object returnObj=null;
		 try {
			 System.out.print("Getter is going to execute using Annotation");
			returnObj=pjp.proceed();
			System.out.print("Getter executed");
		} catch (Throwable e) {
			System.out.print("Exception thrown");
		} //COnditionally proceed the execute}
		return returnObj;
	 }*/
	 //---------------AOP XML Configuration------------------------------
	 /*@Around("forAllGetter()") 
	 public Object myAroundMethod(ProceedingJoinPoint pjp) 
	 {Object returnObj=null;
		 try {
			 System.out.print("Getter is going to execute ");
			returnObj=pjp.proceed();
			System.out.print("Getter executed");
		} catch (Throwable e) {
			System.out.print("Exception thrown");
		} //COnditionally proceed the execute}
		return returnObj;
	 }
*/
}
