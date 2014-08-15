package com.samples.services;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class MyService1Test extends AbstractJUnit4SpringContextTests {
	@Resource
	private MyService1 ms;

	@Test
	public void addTest(){
		int result = ms.add(1, 2);
	}
}
