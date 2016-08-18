package com.cmz.bean.aop;

import java.util.Objects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

import com.cmz.bean.aop.service.IUsageTracked;

@Aspect
public class SystemArchitecture {
	/**
	 * 统计使用次数
	 */
	@DeclareParents(value="com.cmz.controller.*+",defaultImpl=com.cmz.bean.aop.service.DefaultUsageTracked.class)
	private static IUsageTracked tracked;
	
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

	// advice
//	@Before("inServiceLayer() && args(name,..)")
//	public void doBefore(String name) {
//		System.out.println("before:"+name);
//	}
	
	@Before("inServiceLayer() && args(name,..) && this(tracked)")
	public void doBefore(JoinPoint jp,String name,IUsageTracked tracked) {
		StringBuilder args = new StringBuilder();		
		Object[] objects = jp.getArgs();
		if(Objects.nonNull(objects)){
			for(Object object : objects){
				args.append(object.toString());
				args.append(",");
			}
		}
		
		tracked.increateUseCount(jp.getTarget().getClass().getName(),jp.getSignature().getName(),args.toString());
		System.out.println("before:"+name);
	}

	@After("inServiceLayer()")
	public void doAfter() {
		System.out.println("after");
	}

	@AfterReturning("inServiceLayer()")
	public void doAfterReturn() {
		System.out.println("after return");
	}

	@AfterThrowing(pointcut = "inServiceLayer()", throwing = "ex")
	public void doAfterThrow(Throwable ex) {
		ex.printStackTrace();
	}
/*
	@Around("inServiceLayer()")
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		// start stopwatch
		Object retVal = pjp.proceed();
		// stop stopwatch
		return retVal;
	}
*/
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
