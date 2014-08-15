package com.samples.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.samples.controller.DataBindingController;

public class MyInterceptor implements HandlerInterceptor {
	/**
	 * 在preHandle中，可以进行编码、安全控制等处理； 在postHandle中，有机会修改ModelAndView；
	 * 在afterCompletion中，可以根据ex是否为null判断是否发生了异常，进行日志记录。
	 */
	final static Logger logger = LoggerFactory
			.getLogger(DataBindingController.class);

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("MyInterceptor afterCompletion");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		logger.info("MyInterceptor postHandle");
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		logger.info("MyInterceptor preHandle");
		return true;
	}

}
