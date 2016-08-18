package com.cmz.bean.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {
	/**
	 * A join point is in the web layer if the method is defined in a type in
	 * the com.xyz.someapp.web package or any sub-package under that.
	 */
	@Pointcut("execution(public * com.cmz.controller.*.*(..))")
	public void inWebLayer() {
	}

	
	/**
	 * A join point is in the service layer if the method is defined in a type
	 * in the com.xyz.someapp.service package or any sub-package under that.
	 */
	@Pointcut("within(com.cmz.controller..*)")
	public void inServiceLayer() {
	}

	//advice
	@Before("inServiceLayer()")
	public void doBefore(){
		System.out.println("before");
	}
	
	@After("inServiceLayer()")
	public void doAfter(){
		System.out.println("after");
	}
	@AfterReturning("inServiceLayer()")
	public void doAfterReturn(){
		System.out.println("after return");
	}
	@AfterThrowing(pointcut="inServiceLayer()",throwing="ex")
	public void doAfterThrow(Throwable ex){
		ex.printStackTrace();
	}
	
	/**
	 * A join point is in the data access layer if the method is defined in a
	 * type in the com.xyz.someapp.dao package or any sub-package under that.
	 */
	@Pointcut("within(com.xyz.someapp.dao..*)")
	public void inDataAccessLayer() {
	}

	/**
	 * A business service is the execution of any method defined on a service
	 * interface. This definition assumes that interfaces are placed in the
	 * "service" package, and that implementation types are in sub-packages.
	 *
	 * If you group service interfaces by functional area (for example, in
	 * packages com.xyz.someapp.abc.service and com.xyz.someapp.def.service)
	 * then the pointcut expression
	 * "execution(* com.xyz.someapp..service.*.*(..))" could be used instead.
	 *
	 * Alternatively, you can write the expression using the 'bean' PCD, like so
	 * "bean(*Service)". (This assumes that you have named your Spring service
	 * beans in a consistent fashion.)
	 */
	@Pointcut("execution(* com.xyz.someapp..service.*.*(..))")
	public void businessService() {
	}

	/**
	 * A data access operation is the execution of any method defined on a dao
	 * interface. This definition assumes that interfaces are placed in the
	 * "dao" package, and that implementation types are in sub-packages.
	 */
	@Pointcut("execution(* com.xyz.someapp.dao.*.*(..))")
	public void dataAccessOperation() {
	}
}
