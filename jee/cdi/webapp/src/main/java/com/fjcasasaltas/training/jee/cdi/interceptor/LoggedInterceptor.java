package com.fjcasasaltas.training.jee.cdi.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import com.fjcasasaltas.training.jee.cdi.qualifier.Logged;

@Interceptor
@Logged
public class LoggedInterceptor {

	public LoggedInterceptor() {

	}

	@AroundInvoke
	public Object logMethodEntry(InvocationContext invocationContext) throws Exception {
		System.out.println("Executing method '"
				+ invocationContext.getMethod().getName() + "' in class '"
				+ invocationContext.getMethod().getDeclaringClass().getName()
				+ "'");
		return invocationContext.proceed();
	}
	
}
