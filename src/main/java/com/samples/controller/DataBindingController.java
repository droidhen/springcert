package com.samples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dataBinding")
public class DataBindingController {

	final static Logger logger = LoggerFactory
			.getLogger(DataBindingController.class);

	// http://localhost:8080/SpringCertificate/dataBinding/goParam.action?p1=11&p2=22
	@RequestMapping("/goParam")
	// 必须有值，否则抛出异常，如果允许空值请使用包装类代替。
	public void testRequestParam(
			@RequestParam(value = "p1", required = true, defaultValue = "zhang") String param1,
			@RequestParam("p2") String param2) {

		logger.info("testRequestParam: " + param1 + ", " + param2);
	}

	// http://localhost:8080/SpringCertificate/dataBinding/users/11/topics/22.action
	@RequestMapping(value = "/users/{userId}/topics/{topicId}")
	public void testPathVariable(@PathVariable(value = "userId") int userId,
			@PathVariable(value = "topicId") int topicId) {

		logger.info("testPathVariable: " + userId + ", " + topicId);
	}

	// http://localhost:8080/SpringCertificate/dataBinding/checkCookie.action
	@RequestMapping("/checkCookie")
	public void testCookieValue(
			@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId) {
		logger.info("testCookieValue: " + sessionId);
	}

	// http://localhost:8080/SpringCertificate/dataBinding/checkRequestHeader.action
	@RequestMapping("/checkRequestHeader")
	public void testRequestHeader(
			@RequestHeader("User-Agent") String userAgent,
			@RequestHeader(value = "Accept") String[] accepts) {
		logger.info("testRequestHeader: " + userAgent + "," + accepts);
	}
}
