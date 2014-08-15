package com.samples.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * @Controller：用于标识是处理器类；
 * @RequestMapping：请求到处理器功能方法的映射规则；
 * @RequestParam：请求参数到处理器功能处理方法的方法参数上的绑定；
 * @ModelAttribute：请求参数到命令对象的绑定；
 * @SessionAttributes：用于声明session级别存储的属性，放置在处理器类上，通常列出
 *                                                     模型属性（如@ModelAttribute）对应的名称
 *                                                     ，则这些属性会透明的保存到session中；
 * @InitBinder：自定义数据绑定注册支持，用于将请求参数转换到命令对象属性的对应类型；
 *
 *                                                Spring3.0引入RESTful架构风格支持(通过@PathVariable注解和一些其他特性支持
 *                                                ),且又引入了 更多的注解支持：
 * @CookieValue：cookie数据到处理器功能处理方法的方法参数上的绑定；
 * @RequestHeader：请求头（header）数据到处理器功能处理方法的方法参数上的绑定；
 * @RequestBody：请求的body体的绑定（通过HttpMessageConverter进行类型转换）；
 * @ResponseBody：处理器功能处理方法的返回值作为响应体（通过HttpMessageConverter进行类型转换）；
 * @ResponseStatus：定义处理器功能处理方法/异常处理器返回的状态码和原因；
 * @ExceptionHandler：注解式声明异常处理器；
 * @PathVariable：请求URI中的模板变量部分到处理器功能处理方法的方法参数上的绑定， 从而支持RESTful架构风格的URI；
 * */
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
