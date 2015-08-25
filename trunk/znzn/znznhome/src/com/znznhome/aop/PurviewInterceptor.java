package com.znznhome.aop;

import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

import com.opensymphony.xwork2.ActionContext;
import com.znznhome.util.CommonUtil;


public class PurviewInterceptor {
	
	public Object purviewMethod(ProceedingJoinPoint pjp) throws Throwable {
		//Map request = (Map)ActionContext.getContext().get("request");
		//System.out.println(request.get("title"));
		Map session = ActionContext.getContext().getSession();
		if(CommonUtil.isNotEmpty(session.get("purview")) && session.get("purview").equals(1)) {
			return pjp.proceed();
		}else {
			return false;
		}
	}
}
